package be.vdab.personeel;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public abstract class Werknemer implements Comparable<Werknemer> {

    private final int personeelsNummer;
    private WerknemersDatum datuminDienst;
    private String naam;
    private Geslacht geslacht;

    public Werknemer(int personeelsNummer, WerknemersDatum datuminDienst, String naam, Geslacht geslacht) {
        if (personeelsNummer == 0) {
            throw new NumberFormatException("Personeelsnummer moet groter dan 0 zijn!");
        }
        this.personeelsNummer = personeelsNummer;
        setDatuminDienst(datuminDienst);
        setNaam(naam);
        setGeslacht(geslacht);
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public WerknemersDatum getDatuminDienst() {
        return datuminDienst;
    }

    public void setDatuminDienst(WerknemersDatum datum) {
        if (WerknemersDatum.getOprichtingsDatum().compareTo(datum) >= WerknemersDatum.getOprichtingsDatum().hashCode()) {
            throw new WerknemerException("In diensttreding moet later zijn dan de oprichtingsdatum!");
        }
        this.datuminDienst = datum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isEmpty()) {
            throw new NullPointerException("Naam mag niet null of leeg zijn!");
        }
        this.naam = naam;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        if (geslacht == null) {
            throw new NullPointerException("Geslacht mag niet null zijn!");
        }
        this.geslacht = geslacht;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Werknemer werknemer)) {
            return false;
        }
        return personeelsNummer == werknemer.personeelsNummer;
    }

    @Override
    public int hashCode() {
        return personeelsNummer;
    }

    @Override
    public int compareTo(Werknemer w) {
        return personeelsNummer - w.personeelsNummer;
    }

    public abstract BigDecimal getVerloning();

    @Override
    public String toString() {
        return "Personeelsnummer: " + personeelsNummer + "\t" + "In diensttreding: " + datuminDienst + "\t" + "Naam: " + naam + "\t" + "Geslacht: " + geslacht;
    }

    public enum Geslacht { //Enum class in een class
        MAN,
        VROUW,
        X
    }
}
