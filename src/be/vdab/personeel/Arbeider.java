package be.vdab.personeel;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Arbeider extends Werknemer {

    private final BigDecimal minimumUurloon = new BigDecimal("9.76");
    private BigDecimal uurloon;

    public Arbeider(int personeelsNummer, WerknemersDatum datuminDienst, String naam, Geslacht geslacht, BigDecimal uurloon) {
        super(personeelsNummer, datuminDienst, naam, geslacht);
        setUurloon(uurloon);
    }

    public BigDecimal getUurloon() {
        return uurloon;
    }

    public void setUurloon(BigDecimal uurloon) {
        if (minimumUurloon.compareTo(uurloon) > 0) {
            throw new WerknemerException("Minimumloon moet " + minimumUurloon + " zijn!");
        }
        this.uurloon = uurloon;
    }

    @Override
    public BigDecimal getVerloning() {
        return uurloon.multiply(BigDecimal.valueOf(7.6 * 65)).divide(BigDecimal.valueOf(3), RoundingMode.HALF_DOWN);
    }

    @Override
    public String toString() {
        return "Personeelsnummer: " + getPersoneelsNummer() + "\t" + "In diensttreding: " + getDatuminDienst() + "\t"
                + "Naam: " + getNaam() + "\t" + "Geslacht: " + getGeslacht()
                + "\t" + "Uurloon: " + uurloon + "\t" + "Maandverloning: " + getVerloning();
    }
}
