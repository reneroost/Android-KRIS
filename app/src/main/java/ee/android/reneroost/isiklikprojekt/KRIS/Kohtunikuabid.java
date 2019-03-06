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
        Kohtunikuabi kohtunikuabi1 = new Kohtunikuabi("Anneli Luur", true, true);
        Kohtunikuabi kohtunikuabi2 = new Kohtunikuabi("Anu Kruus", true, false);
        Kohtunikuabi kohtunikuabi3 = new Kohtunikuabi("Ave Talts", true, true);
        Kohtunikuabi kohtunikuabi4 = new Kohtunikuabi("Eva Nemvalts", true, false);
        Kohtunikuabi kohtunikuabi5 = new Kohtunikuabi("Helle Eduvald", true, true);
        Kohtunikuabi kohtunikuabi6 = new Kohtunikuabi("Ilona Kirm", true, true);
        Kohtunikuabi kohtunikuabi7 = new Kohtunikuabi("Jaan Unt", false, true);
        Kohtunikuabi kohtunikuabi8 = new Kohtunikuabi("Kariina Orr", true, false);
        Kohtunikuabi kohtunikuabi9 = new Kohtunikuabi("Katrin Kokk", true, false);
        Kohtunikuabi kohtunikuabi10 = new Kohtunikuabi("Sigrid Orumets", true, true);
        Kohtunikuabi kohtunikuabi11 = new Kohtunikuabi("Tiiu Karu", true, true);
        Kohtunikuabi kohtunikuabi12 = new Kohtunikuabi("Ülle Juhanson", true, false);

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
}
