package be.vdab;

import be.vdab.personeel.*;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.DatumException;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class BedrijApp {

    public static void main(String[] args) {
        Bedrijf bedrijf = new Bedrijf(); //Creating instance van bedrijf

        try {
            bedrijf.voegWerknemerToe(new Arbeider(21, new WerknemersDatum(1, 3, 2016),
                    "Jan Malfliet", Werknemer.Geslacht.MAN, BigDecimal.valueOf(13.5)));
        } catch (WerknemerException | DatumException e) {
            e.printStackTrace();
        }

        try {
            bedrijf.voegWerknemerToe(new Kaderlid(63, new WerknemersDatum(7,2,2023),
                    "Senne Goossens", Werknemer.Geslacht.MAN, BigDecimal.valueOf(3000), Kaderlid.FunctieTitel.CEO));
        } catch (WerknemerException | DatumException e) {
            e.printStackTrace();
        }

        try {
            bedrijf.voegWerknemerToe(new Kaderlid(6, new WerknemersDatum(25,10,2010),
                    "Ilse Goossens", Werknemer.Geslacht.VROUW, BigDecimal.valueOf(3641.25), Kaderlid.FunctieTitel.MANAGER));
        } catch (WerknemerException | DatumException e) {
            e.printStackTrace();
        }

        bedrijf.gesorteerdeLijst().forEach(System.out::println); //Sorteerd op natuurlijke volgorde (Personeelsnummer)

        try {
            bedrijf.voegWerknemerToe(new Bediende(26, new WerknemersDatum(5, 6, 1830),
                    "Kristel Colman", Werknemer.Geslacht.VROUW, BigDecimal.valueOf(2345.56)));
        } catch (WerknemerException | DatumException e) {
            e.printStackTrace();
        }

        try {
            bedrijf.voegWerknemerToe(new Kaderlid(13, new WerknemersDatum(30, 1, 1726),
                    "Stijn Goossens", Werknemer.Geslacht.MAN, BigDecimal.valueOf(2345.56), Kaderlid.FunctieTitel.DIRECTEUR));
        } catch (WerknemerException | DatumException e) {
            e.printStackTrace();
        }

        System.out.println(bedrijf.percentageMannelijkeWerknemers()); //Returnt percentage van mannelijke werknemers
        bedrijf.lijstVanArbeiders().forEach(System.out::println); //Print lijst met alle arbeiders gegevens
        bedrijf.bewaarLijst(); //Bewaren van lijst naar document Path(/data/personeel.dat)

        try { //Foute uurloon (lager dan 9.76) Werknemer error wordt opgevangen.
            bedrijf.voegWerknemerToe(new Arbeider(69, new WerknemersDatum(3,6,2015),
                    "Marie Louise", Werknemer.Geslacht.VROUW, BigDecimal.valueOf(6.21)));
        } catch (WerknemerException | DatumException e) {
            e.printStackTrace();
        }

        try { //Foute naam (naam isEmpty) Werknemer error wordt opgevangen.
            bedrijf.voegWerknemerToe(new Bediende(54, new WerknemersDatum(21, 5, 2021),
                    "", Werknemer.Geslacht.X, BigDecimal.valueOf(1800.45)));
        } catch (WerknemerException | DatumException e) {
            e.printStackTrace();
        }

        bedrijf.printLijst(bedrijf.getBedrijfsLijst());
    }
}
