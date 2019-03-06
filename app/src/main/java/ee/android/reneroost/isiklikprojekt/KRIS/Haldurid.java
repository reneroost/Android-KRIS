package ee.android.reneroost.isiklikprojekt.KRIS;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Haldurid {

    private static Haldurid sHaldurid;

    private List<Haldur> mHaldurid;

    public static Haldurid saa(Context kontekst) {
        if(sHaldurid == null) {
            sHaldurid = new Haldurid(kontekst);
        }
        return sHaldurid;
    }

    private Haldurid(Context kontekst) {
        mHaldurid = new ArrayList<>();
        Haldur haldur1 = new Haldur("Eric Rikberg", false, false, true);
        Haldur haldur2 = new Haldur("Karl Rikson", false, true, true);
        Haldur haldur3 = new Haldur("Rene Rikiver", false, false, true);
        Haldur haldur4 = new Haldur("Piret Rikstein", true, true, false);
        Haldur haldur5 = new Haldur("Anete Rikobsen", true, false, false);
        Haldur haldur6 = new Haldur("Kirill Rikov", false, true, false);
        Haldur haldur7 = new Haldur("Kristian Riksi", false, false, false);
        mHaldurid.add(haldur1);
        mHaldurid.add(haldur2);
        mHaldurid.add(haldur3);
        mHaldurid.add(haldur4);
        mHaldurid.add(haldur5);
        mHaldurid.add(haldur6);
        mHaldurid.add(haldur7);
    }

    public List<Haldur> saaHaldurid() {
        return mHaldurid;
    }

    public Haldur saaHaldur(String nimi) {
        for (Haldur haldur: mHaldurid) {
            if(haldur.saaNimi().equals(nimi)) {
                return haldur;
            }
        }
        return null;
    }
}
