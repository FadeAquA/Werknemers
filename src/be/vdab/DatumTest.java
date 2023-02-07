package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;

public class DatumTest {

    public static void main(String[] args) {

        var datums = new Datum[4];

        datums[0] = new Datum(13, 2, 2357); //Correcte datum
        System.out.println(datums[0]);

        datums[1] = new Datum(0, 5, 1666); //Parameter dag is fout
        System.out.println(datums[1]); //print datum niet want exception wordt opgevangen (stopt ook code hieronder)

        datums[2] = new Datum(12, 16, 1999); //Parameter maand is fout

        datums[3] = new Datum(16, 9, 1000); //Parameter jaar is fout


    }
}
