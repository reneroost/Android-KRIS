package ee.android.reneroost.isiklikprojekt.KRIS;

public class Kinnisvara {

    private int mRegistriosaNr;
    private String mKinnisvaraNimi;
    private String mAadress;
    private String mOmanik;
    private int mVaartusEur;

    public Kinnisvara(int registriosaNr, String kinnisvaraNimi, String aadress, String omanik, int vaartusEur) {
        mRegistriosaNr = registriosaNr;
        mKinnisvaraNimi = kinnisvaraNimi;
        mAadress = aadress;
        mOmanik = omanik;
        mVaartusEur = vaartusEur;
    }

}
