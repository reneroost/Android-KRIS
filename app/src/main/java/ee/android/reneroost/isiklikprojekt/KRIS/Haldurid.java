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
        Haldur haldur1 = new Haldur("Eric Rikberg" , R.drawable.haldur_mees_blond, false, false, true);
        Haldur haldur2 = new Haldur("Karl Rikson", R.drawable.haldur_mees_brunett, false, true, true);
        Haldur haldur3 = new Haldur("Rene Rikiver", R.drawable.haldur_mees_blond, false, false, true);
        Haldur haldur4 = new Haldur("Piret Rikstein", R.drawable.haldur_naine_brunett, true, true, false);
        Haldur haldur5 = new Haldur("Anete Rikobsen", R.drawable.haldur_naine_blond, true, false, false);
        Haldur haldur6 = new Haldur("Kirill Rikov", R.drawable.haldur_mees_brunett, false, true, false);
        Haldur haldur7 = new Haldur("Kristian Riksi", R.drawable.haldur_mees_brunett, false, false, false);
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
