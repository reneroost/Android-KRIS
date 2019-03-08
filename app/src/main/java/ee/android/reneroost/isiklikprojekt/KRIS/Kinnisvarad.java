package ee.android.reneroost.isiklikprojekt.KRIS;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Kinnisvarad {

    private static Kinnisvarad sKinnisvarad;

    private List<Kinnisvara> mKinnisvarad;

    public static synchronized Kinnisvarad saa() {
        if (sKinnisvarad == null) {
            sKinnisvarad = new Kinnisvarad();
        }
        return sKinnisvarad;
    }

    private Kinnisvarad() {
        mKinnisvarad = new ArrayList<>();
        Kinnisvara kinnisvara1 = new Kinnisvara(81588, "Coca-Cola Plaza",
                "Hobujaama 5, 10151, Tallinn", "Katrin Hunt", 600000);

        Kinnisvara kinnisvara2 = new Kinnisvara(85857, "Teletorn",
                "Kloostrimetsa tee 58a, 11913, Tallinn", "Rein Kapp", 600000);

        Kinnisvara kinnisvara3 = new Kinnisvara(16134, "Tallinna sadam",
                "Sadama 25, 15051, Tallinn", "Leena Peterson", 2000000);

        Kinnisvara kinnisvara4 = new Kinnisvara(33778, "Tehvandi spordikeskus",
                "Nüpli küla, 67408, Otepää vald", "Alexandra Abel", 1000000);

        Kinnisvara kinnisvara5 = new Kinnisvara(42800, "Eesti Rahvusraamatukogu",
                "Tõnismägi 2, 10119, Tallinn", "Mari Kask", 1400000);

        Kinnisvara kinnisvara6 = new Kinnisvara(35128, "A. Le Coq Arena",
                "Asula 4c, 11312, Tallinn", "Teet Eenpalu", 1400000);

        Kinnisvara kinnisvara7 = new Kinnisvara(29918, "Eesti Kunstimuuseum",
                "Weizenbergi 34, 10127, Tallinn", "Leena Peterson", 1800000);

        Kinnisvara kinnisvara8 = new Kinnisvara(91720, "Tartu Ülikool",
                "Ülikooli 18, 50090, Tartu", "Sofia Kukk", 1800000);

        Kinnisvara kinnisvara9 = new Kinnisvara(58714, "Rahvusooper Estonia",
                "Estonia pst 4, 10143, Tallinn", "Enno Piip", 2000000);

        Kinnisvara kinnisvara10 = new Kinnisvara(91590, "Kadrioru loss",
                "Weizenbergi 37, 10127, Tallinn", "Kaia Ivanova", 2200000);

        Kinnisvara kinnisvara11 = new Kinnisvara(22951, "Kadrioru park",
                "Weizenbergi 26, 10127, Tallinn", "Kaia Ivanova", 2200000);

        Kinnisvara kinnisvara12 = new Kinnisvara(40122, "Pirita klooster",
                "Merivälja tee 18, 11911, Tallinn", "Marika Kask", 2400000);

        Kinnisvara kinnisvara13 = new Kinnisvara(71080, "Tallinna lennujaam",
                "Tartu mnt 101, 10112, Tallinn", "Priit Leok", 2000000);

        Kinnisvara kinnisvara14 = new Kinnisvara(93729, "Lauluväljak",
                "Narva mnt 95, 10127, Tallinn", "Johanna Ilves", 2600000);

        Kinnisvara kinnisvara15 = new Kinnisvara(93485, "Radisson SAS hotell",
                "Rävala puiestee 3, 10143, Tallinn", "Marika Kask", 2600000);

        Kinnisvara kinnisvara16 = new Kinnisvara(16588, "Kaubamaja",
                "Gonsiori 2, 10143, Tallinn", "Laine Oliver", 1500000);

        Kinnisvara kinnisvara17 = new Kinnisvara(49768, "Vabaõhumuuseum",
                "Vabaõhumuuseumi tee 12, 13521, Tallinn", "Kaia Ivanova", 3000000);

        Kinnisvara kinnisvara18 = new Kinnisvara(87088, "Paks Margareeta",
                "Pikk 70, 10133, Tallinn", "Janar Kask", 3200000);

        Kinnisvara kinnisvara19 = new Kinnisvara(38215, "Raekoja plats",
                "Raekoja plats 1, 10114, Tallinn", "Ivari Kangro", 3500000);

        Kinnisvara kinnisvara20 = new Kinnisvara(11488, "Toompea loss",
                "Lossi plats 1a, 10137, Tallinn", "Kaja Adamson", 4000000);
    }

}
