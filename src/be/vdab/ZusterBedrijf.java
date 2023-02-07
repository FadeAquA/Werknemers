package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ZusterBedrijf {

    public static void main(String[] args) {

        Path path = Path.of("/data/personeel.dat");

        //Leest het personeel bestand en print elke lijn uit.
        try (var lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
