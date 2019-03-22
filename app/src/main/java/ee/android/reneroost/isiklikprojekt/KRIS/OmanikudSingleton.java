package ee.android.reneroost.isiklikprojekt.KRIS;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OmanikudSingleton {

    private static OmanikudSingleton sOmanikudSingleton;

    private List<Omanik> mOmanikud;

    public static synchronized OmanikudSingleton saaInstants() {
        if (sOmanikudSingleton == null) {
            sOmanikudSingleton = new OmanikudSingleton();
        }
        return sOmanikudSingleton;
    }

    public List<Omanik> saaOmanikud() {
        return mOmanikud;
    }

    private OmanikudSingleton() {
        mOmanikud = new ArrayList<>();

        Omanik omanik1 = new Omanik("Katrin Hunt", 45654564896L, 0);
        Omanik omanik2 = new Omanik("Rein Kapp", 38747874877L, 0);
        Omanik omanik3 = new Omanik("Leena Peterson", 49494184418L, 1);
        Omanik omanik4 = new Omanik("Alexandra Ivanova", 43178464869L, 1);
        Omanik omanik5 = new Omanik("Mari Kask", 44165489648L, 0);
        Omanik omanik6 = new Omanik("Teet Eenpalu", 34661984896L, 0);
        Omanik omanik7 = new Omanik("Sofia Nemetski", 46258478949L, 1);
        Omanik omanik8 = new Omanik("Enno Piip", 3468746846L, 0);
        Omanik omanik9 = new Omanik("Kaia Abel", 41968849848L, 0);
        Omanik omanik10 = new Omanik("Marika Kask", 48419846984L, 0);
        Omanik omanik11 = new Omanik("Priit Leok", 39842319498L, 0);
        Omanik omanik12 = new Omanik("Johanna Ilves", 28904025582L, 0);
        Omanik omanik13 = new Omanik("Laine Oliver", 45408520783L, 0);
        Omanik omanik14 = new Omanik("Janar Kask", 38457294387L, 0);
        Omanik omanik15 = new Omanik("Ivari Kangro", 38843258042L, 0);
        Omanik omanik16 = new Omanik("Kaja Adamson", 49842319498L, 0);

        mOmanikud.add(omanik1);
        mOmanikud.add(omanik2);
        mOmanikud.add(omanik3);
        mOmanikud.add(omanik4);
        mOmanikud.add(omanik5);
        mOmanikud.add(omanik6);
        mOmanikud.add(omanik7);
        mOmanikud.add(omanik8);
        mOmanikud.add(omanik9);
        mOmanikud.add(omanik10);
        mOmanikud.add(omanik11);
        mOmanikud.add(omanik12);
        mOmanikud.add(omanik13);
        mOmanikud.add(omanik14);
        mOmanikud.add(omanik15);
        mOmanikud.add(omanik16);
    }

    public Omanik saaOmanik(UUID id) {
        for (Omanik omanik: mOmanikud) {
            if (omanik.saaId() == id) {
                return omanik;
            }
        }
        return null;
    }
}
