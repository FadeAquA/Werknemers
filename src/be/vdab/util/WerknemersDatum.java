package be.vdab.util;

public class WerknemersDatum extends Datum {

    private final static Datum oprichtingsDatum = new Datum(12,2, 1977);

    public WerknemersDatum(int dag, int maand, int jaar) {
        super(dag, maand, jaar);
    }

    public static Datum getOprichtingsDatum() {
        return oprichtingsDatum;
    }
}
