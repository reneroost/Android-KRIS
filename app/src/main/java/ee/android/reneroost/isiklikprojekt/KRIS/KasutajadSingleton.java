package ee.android.reneroost.isiklikprojekt.KRIS;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class KasutajadSingleton {
    public static KasutajadSingleton sKasutajadSingleton;

    private List<Kasutaja> mKasutajad;

    public static KasutajadSingleton saaInstants(Context kontekst) {
        if(sKasutajadSingleton == null) {
            sKasutajadSingleton = new KasutajadSingleton();
        }
        return sKasutajadSingleton;
    }

    public List<Kasutaja> saaKasutajad() {
        return mKasutajad;
    }

    private KasutajadSingleton() {
        mKasutajad = new ArrayList<>();

        Haldur haldur1 = new Haldur("Eric Rikberg", 1, R.drawable.haldur_mees_blond, false, false, true);
        Haldur haldur2 = new Haldur("Karl Rikson", 1, R.drawable.haldur_mees_brunett, false, true, true);
        Haldur haldur3 = new Haldur("Rene Rikiver", 1, R.drawable.haldur_mees_blond, false, false, true);
        Haldur haldur4 = new Haldur("Piret Rikstein", 2, R.drawable.haldur_naine_brunett, true, true, false);
        Haldur haldur5 = new Haldur("Anete Rikobsen", 2, R.drawable.haldur_naine_blond, true, false, false);
        Haldur haldur6 = new Haldur("Kirill Rikov", 2, R.drawable.haldur_mees_brunett, false, true, false);
        Haldur haldur7 = new Haldur("Kristian Riksi", 2, R.drawable.haldur_mees_brunett, false, false, false);
        mKasutajad.add(haldur1);
        mKasutajad.add(haldur2);
        mKasutajad.add(haldur3);
        mKasutajad.add(haldur4);
        mKasutajad.add(haldur5);
        mKasutajad.add(haldur6);
        mKasutajad.add(haldur7);

        Kohtunikuabi kohtunikuabi1 = new Kohtunikuabi("Aili Sillar", 0, R.drawable.kohtunikuabi_naine_brunett,true, true);
        Kohtunikuabi kohtunikuabi2 = new Kohtunikuabi("Aivar Vimberg", 0, R.drawable.kohtunikuabi_mees_brunett,false, true);
        Kohtunikuabi kohtunikuabi3 = new Kohtunikuabi("Anneli Luur", 0, R.drawable.kohtunikuabi_naine_brunett,true, true);
        Kohtunikuabi kohtunikuabi4 = new Kohtunikuabi("Anu Kruus", 0, R.drawable.kohtunikuabi_naine_blond, true, false);
        Kohtunikuabi kohtunikuabi5 = new Kohtunikuabi("Ave Roosvelt", 0, R.drawable.kohtunikuabi_naine_brunett,true, true);
        Kohtunikuabi kohtunikuabi6 = new Kohtunikuabi("Ave Talts", 0, R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi7 = new Kohtunikuabi("Ester Kärner", 0, R.drawable.kohtunikuabi_naine_blond,true, false);
        Kohtunikuabi kohtunikuabi8 = new Kohtunikuabi("Eva Nemvalts", 0, R.drawable.kohtunikuabi_naine_blond, true, false);
        Kohtunikuabi kohtunikuabi9 = new Kohtunikuabi("Helle Eduvald", 0, R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi10 = new Kohtunikuabi("Ilona Kirm", 0, R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi11 = new Kohtunikuabi("Jaan Unt", 0, R.drawable.haldur_mees_brunett, false, true);
        Kohtunikuabi kohtunikuabi12 = new Kohtunikuabi("Kariina Orr", 0, R.drawable.kohtunikuabi_naine_blond, true, false);
        Kohtunikuabi kohtunikuabi13 = new Kohtunikuabi("Katrin Kokk", 0, R.drawable.kohtunikuabi_naine_blond, true, false);
        Kohtunikuabi kohtunikuabi14 = new Kohtunikuabi("Markko Voll", 0, R.drawable.kohtunikuabi_mees_brunett,false, true);
        Kohtunikuabi kohtunikuabi15 = new Kohtunikuabi("Marten Soosaar", 0, R.drawable.kohtunikuabi_mees_brunett,false, true);
        Kohtunikuabi kohtunikuabi16 = new Kohtunikuabi("Sigrid Orumets", 0, R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi17 = new Kohtunikuabi("Sirje Laiksoo", 0, R.drawable.kohtunikuabi_naine_blond,true, false);
        Kohtunikuabi kohtunikuabi18 = new Kohtunikuabi("Tiiu Karu", 0, R.drawable.kohtunikuabi_naine_brunett, true, true);
        Kohtunikuabi kohtunikuabi19 = new Kohtunikuabi("Ülle Juhanson", 0, R.drawable.kohtunikuabi_naine_blond, true, false);

        mKasutajad.add(kohtunikuabi1);
        mKasutajad.add(kohtunikuabi2);
        mKasutajad.add(kohtunikuabi3);
        mKasutajad.add(kohtunikuabi4);
        mKasutajad.add(kohtunikuabi5);
        mKasutajad.add(kohtunikuabi6);
        mKasutajad.add(kohtunikuabi7);
        mKasutajad.add(kohtunikuabi8);
        mKasutajad.add(kohtunikuabi9);
        mKasutajad.add(kohtunikuabi10);
        mKasutajad.add(kohtunikuabi11);
        mKasutajad.add(kohtunikuabi12);
        mKasutajad.add(kohtunikuabi13);
        mKasutajad.add(kohtunikuabi14);
        mKasutajad.add(kohtunikuabi15);
        mKasutajad.add(kohtunikuabi16);
        mKasutajad.add(kohtunikuabi17);
        mKasutajad.add(kohtunikuabi18);
        mKasutajad.add(kohtunikuabi19);


    }
}
