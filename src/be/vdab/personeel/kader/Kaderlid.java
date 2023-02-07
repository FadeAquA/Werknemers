package be.vdab.personeel.kader;

import be.vdab.personeel.Bediende;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class Kaderlid extends Bediende {

    private FunctieTitel functieTitel;

    public Kaderlid(int personeelsNummer, WerknemersDatum datuminDienst, String naam, Geslacht geslacht, BigDecimal maandWedde, FunctieTitel functieTitel) {
        super(personeelsNummer, datuminDienst, naam, geslacht, maandWedde);
        setFunctieTitel(functieTitel);
    }

    public FunctieTitel getFunctieTitel() {
        return functieTitel;
    }

    public void setFunctieTitel(FunctieTitel functieTitel) {
        if (functieTitel == null) {
            throw new WerknemerException("FunctieTitel is verplicht in te vullen!");
        }
        this.functieTitel = functieTitel;
    }

    @Override
    public String toString() {
        return "Personeelsnummer: " + getPersoneelsNummer() + "\t" + "In diensttreding: " + getDatuminDienst() + "\t"
                + "Naam: " + getNaam() + "\t" + "Geslacht: " + getGeslacht()
                + "\t" + "Functie: " + functieTitel + "\t" + "Maandverloning: " + getVerloning();
    }

    public enum FunctieTitel { //Enum class in een class
        DIRECTEUR,
        CEO,
        MANAGER
    }
}
