package ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara;

import java.util.ArrayList;
import java.util.List;

public class KinnisvaradSingleton {

    private static KinnisvaradSingleton sKinnisvaradSingleton;

    private List<Kinnisvara> mKinnisvarad;

    public static synchronized KinnisvaradSingleton saaInstants() {
        if (sKinnisvaradSingleton == null) {
            sKinnisvaradSingleton = new KinnisvaradSingleton();
        }
        return sKinnisvaradSingleton;
    }

    public List<Kinnisvara> saaKinnisvarad() {
        return mKinnisvarad;
    }

    private KinnisvaradSingleton() {
        mKinnisvarad = new ArrayList<>();
        List<Omanik> omanikud = OmanikudSingleton.saaInstants().saaOmanikud();
        Kinnisvara kinnisvara1 = new Kinnisvara(81588, "Coca-Cola Plaza",
                "Hobujaama 5, 10151, Tallinn", omanikud.get(0).saaId(), 600000);

        Kinnisvara kinnisvara2 = new Kinnisvara(85857, "Teletorn",
                "Kloostrimetsa tee 58a, 11913, Tallinn",  omanikud.get(1).saaId(), 600000);

        Kinnisvara kinnisvara3 = new Kinnisvara(16134, "Tallinna sadam",
                "Sadama 25, 15051, Tallinn",  omanikud.get(2).saaId(), 2000000);

        Kinnisvara kinnisvara4 = new Kinnisvara(33778, "Tehvandi spordikeskus",
                "Nüpli küla, 67408, Otepää vald",  omanikud.get(4).saaId(), 1000000);

        Kinnisvara kinnisvara5 = new Kinnisvara(42800, "Eesti Rahvusraamatukogu",
                "Tõnismägi 2, 10119, Tallinn",  omanikud.get(5).saaId(), 1400000);

        Kinnisvara kinnisvara6 = new Kinnisvara(35128, "A. Le Coq Arena",
                "Asula 4c, 11312, Tallinn",  omanikud.get(6).saaId(), 1400000);

        Kinnisvara kinnisvara7 = new Kinnisvara(29918, "Eesti Kunstimuuseum",
                "Weizenbergi 34, 10127, Tallinn",  omanikud.get(7).saaId(), 1800000);

        Kinnisvara kinnisvara8 = new Kinnisvara(91720, "Tartu Ülikool",
                "Ülikooli 18, 50090, Tartu",  omanikud.get(8).saaId(), 1800000);

        Kinnisvara kinnisvara9 = new Kinnisvara(58714, "Rahvusooper Estonia",
                "Estonia pst 4, 10143, Tallinn",  omanikud.get(9).saaId(), 2000000);

        Kinnisvara kinnisvara10 = new Kinnisvara(91590, "Kadrioru loss",
                "Weizenbergi 37, 10127, Tallinn",  omanikud.get(10).saaId(), 2200000);

        Kinnisvara kinnisvara11 = new Kinnisvara(22951, "Kadrioru park",
                "Weizenbergi 26, 10127, Tallinn",  omanikud.get(11).saaId(), 2200000);

        Kinnisvara kinnisvara12 = new Kinnisvara(40122, "Pirita klooster",
                "Merivälja tee 18, 11911, Tallinn",  omanikud.get(12).saaId(), 2400000);

        Kinnisvara kinnisvara13 = new Kinnisvara(71080, "Tallinna lennujaam",
                "Tartu mnt 101, 10112, Tallinn",  omanikud.get(13).saaId(), 2000000);

        Kinnisvara kinnisvara14 = new Kinnisvara(93729, "Lauluväljak",
                "Narva mnt 95, 10127, Tallinn",  omanikud.get(14).saaId(), 2600000);

        Kinnisvara kinnisvara15 = new Kinnisvara(93485, "Radisson SAS hotell",
                "Rävala puiestee 3, 10143, Tallinn",  omanikud.get(15).saaId(), 2600000);

        Kinnisvara kinnisvara16 = new Kinnisvara(16588, "Kaubamaja",
                "Gonsiori 2, 10143, Tallinn",  omanikud.get(15).saaId(), 1500000);

        Kinnisvara kinnisvara17 = new Kinnisvara(49768, "Vabaõhumuuseum",
                "Vabaõhumuuseumi tee 12, 13521, Tallinn",  omanikud.get(4).saaId(), 3000000);

        Kinnisvara kinnisvara18 = new Kinnisvara(87088, "Paks Margareeta",
                "Pikk 70, 10133, Tallinn",  omanikud.get(9).saaId(), 3200000);

        Kinnisvara kinnisvara19 = new Kinnisvara(38215, "Raekoja plats",
                "Raekoja plats 1, 10114, Tallinn",  omanikud.get(3).saaId(), 3500000);

        Kinnisvara kinnisvara20 = new Kinnisvara(11488, "Toompea loss",
                "Lossi plats 1a, 10137, Tallinn",  omanikud.get(12).saaId(), 4000000);

        mKinnisvarad.add(kinnisvara1);
        mKinnisvarad.add(kinnisvara2);
        mKinnisvarad.add(kinnisvara3);
        mKinnisvarad.add(kinnisvara4);
        mKinnisvarad.add(kinnisvara5);
        mKinnisvarad.add(kinnisvara6);
        mKinnisvarad.add(kinnisvara7);
        mKinnisvarad.add(kinnisvara8);
        mKinnisvarad.add(kinnisvara9);
        mKinnisvarad.add(kinnisvara10);
        mKinnisvarad.add(kinnisvara11);
        mKinnisvarad.add(kinnisvara12);
        mKinnisvarad.add(kinnisvara13);
        mKinnisvarad.add(kinnisvara14);
        mKinnisvarad.add(kinnisvara15);
        mKinnisvarad.add(kinnisvara16);
        mKinnisvarad.add(kinnisvara17);
        mKinnisvarad.add(kinnisvara18);
        mKinnisvarad.add(kinnisvara19);
        mKinnisvarad.add(kinnisvara20);

    }

}
