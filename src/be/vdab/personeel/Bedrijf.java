package be.vdab.personeel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Bedrijf {

    private final List<Werknemer> bedrijfsLijst = new ArrayList<>();

    public List<Werknemer> getBedrijfsLijst() {
        return bedrijfsLijst;
    }

    public void voegWerknemerToe(Werknemer werknemer) {
        if (bedrijfsLijst.contains(werknemer)) {
            return;
        }
        bedrijfsLijst.add(werknemer);
    }

    public void printLijst(List<Werknemer> lijst) {
        lijst.forEach(System.out::println);
    }

    public List<Werknemer> gesorteerdeLijst() {
        return bedrijfsLijst.stream().sorted().toList();
    }

    public List<Arbeider> lijstVanArbeiders() {
        List<Arbeider> arbeiderList = new ArrayList<>();
        bedrijfsLijst.stream()
                .filter(werknemer -> werknemer instanceof Arbeider)
                .forEach(arbeider -> arbeiderList.add((Arbeider) arbeider));
        return arbeiderList;
    }

    public String percentageMannelijkeWerknemers() {
        long aantalMannelijkeWerknemers = bedrijfsLijst.stream().filter(werknemer -> werknemer.getGeslacht() == Werknemer.Geslacht.MAN).count();
        long aantalWerknemers = bedrijfsLijst.size();

        return  (double) aantalMannelijkeWerknemers /  aantalWerknemers * 100 + "%";
    }

    public void bewaarLijst() {
        Path path = Path.of("/data/personeel.dat");
        try (var writer = Files.newBufferedWriter(path)) {

            bedrijfsLijst.forEach(werknemer -> {
                try {
                    writer.write(werknemer.toString());
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
