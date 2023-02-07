package be.vdab.util;

import java.util.Objects;

public class Datum implements IDatum, Comparable<Datum>{

    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) {
        setDag(dag);
        setMaand(maand);
        setJaar(jaar);
    }

    private void setDag(int dag) {
        if (dag < 1 || dag > 31) {
            throw new DatumException("Dag moet groter dan 1 en kleiner dan 31 zijn!");
        }
        this.dag = dag;
    }

    private void setMaand(int maand) {
        if (maand < 1 || maand > 12) {
            throw new DatumException("Maand moet groter dan 1 en kleiner dan 12 zijn!");
        }
        this.maand = maand;
    }

    private void setJaar(int jaar) {
        if (jaar < 1584 || jaar > 4099) {
            throw new DatumException("Jaar moet groter dan 1584 en kleiner dan 4099 zijn!");
        }
        this.jaar = jaar;
    }

    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    @Override
    public int compareTo(Datum o) {
        return hashCode() - o.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Datum datum)) return false;
        return dag == datum.dag && maand == datum.maand && jaar == datum.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag, maand, jaar);
    }

    @Override
    public String toString() {
        return getDag() + "/" + getMaand() + "/" + getJaar();
    }
}
