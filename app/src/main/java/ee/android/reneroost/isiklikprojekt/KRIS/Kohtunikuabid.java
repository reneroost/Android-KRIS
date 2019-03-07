package ee.android.reneroost.isiklikprojekt.KRIS;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Kohtunikuabid {

    private static Kohtunikuabid sKohtunikuabid;

    private List<Kohtunikuabi> mKohtunikuabid;

    public static Kohtunikuabid saa(Context kontekst) {
        if(sKohtunikuabid == null) {
            sKohtunikuabid = new Kohtunikuabid(kontekst);
        }
        return sKohtunikuabid;
    }

    public String saaRoll() {
        return "kohtunikuabi";
    }

    private Kohtunikuabid(Context kontekst) {
        mKohtunikuabid = new ArrayList<>();
        Kohtunikuabi kohtunikuabi1 = new Kohtunikuabi("Anneli Luur", R.drawable.kohtunikuabi_naine_brunett,true, true);
        Kohtunikuabi kohtunikuabi2 = new Kohtunikuabi("Anu Kruus", R.drawable.kohtunikuabi_naine_blond, true, false);
        Kohtunikuabi kohtunikuabi3 = new Kohtunikuabi("Ave Talts", R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi4 = new Kohtunikuabi("Eva Nemvalts", R.drawable.kohtunikuabi_naine_blond, true, false);
        Kohtunikuabi kohtunikuabi5 = new Kohtunikuabi("Helle Eduvald", R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi6 = new Kohtunikuabi("Ilona Kirm", R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi7 = new Kohtunikuabi("Jaan Unt", R.drawable.haldur_mees_brunett, false, true);
        Kohtunikuabi kohtunikuabi8 = new Kohtunikuabi("Kariina Orr", R.drawable.kohtunikuabi_naine_blond, true, false);
        Kohtunikuabi kohtunikuabi9 = new Kohtunikuabi("Katrin Kokk", R.drawable.kohtunikuabi_naine_blond, true, false);
        Kohtunikuabi kohtunikuabi10 = new Kohtunikuabi("Sigrid Orumets", R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi11 = new Kohtunikuabi("Tiiu Karu", R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi12 = new Kohtunikuabi("Ülle Juhanson", R.drawable.kohtunikuabi_naine_blond, true, false);

        mKohtunikuabid.add(kohtunikuabi1);
        mKohtunikuabid.add(kohtunikuabi2);
        mKohtunikuabid.add(kohtunikuabi3);
        mKohtunikuabid.add(kohtunikuabi4);
        mKohtunikuabid.add(kohtunikuabi5);
        mKohtunikuabid.add(kohtunikuabi6);
        mKohtunikuabid.add(kohtunikuabi7);
        mKohtunikuabid.add(kohtunikuabi8);
        mKohtunikuabid.add(kohtunikuabi9);
        mKohtunikuabid.add(kohtunikuabi10);
        mKohtunikuabid.add(kohtunikuabi11);
        mKohtunikuabid.add(kohtunikuabi12);
    }

    public List<Kohtunikuabi> saaKohtunikuabid() {
        return mKohtunikuabid;
    }
}
