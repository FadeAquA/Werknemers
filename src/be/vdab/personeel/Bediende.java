package be.vdab.personeel;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class Bediende extends Werknemer {

    private BigDecimal maandWedde;
    private final BigDecimal minimumWedde = BigDecimal.valueOf(1129.47);

    public Bediende(int personeelsNummer, WerknemersDatum datuminDienst, String naam, Geslacht geslacht, BigDecimal maandWedde) {
        super(personeelsNummer, datuminDienst, naam, geslacht);
        setMaandWedde(maandWedde);
    }

    public void setMaandWedde(BigDecimal maandWedde) {
        if (minimumWedde.compareTo(maandWedde) > 0) {
            throw new WerknemerException("Maandwedde moet minstens " + minimumWedde + " zijn!");
        }
        this.maandWedde = maandWedde;
    }

    @Override
    public BigDecimal getVerloning() {
        return maandWedde;
    }

    @Override
    public String toString() {
        return "Personeelsnummer: " + getPersoneelsNummer() + "\t" + "In diensttreding: " + getDatuminDienst() + "\t"
                + "Naam: " + getNaam() + "\t" + "Geslacht: " + getGeslacht()
                + "\t" + "Maand Wedde: " + maandWedde;
    }
}
