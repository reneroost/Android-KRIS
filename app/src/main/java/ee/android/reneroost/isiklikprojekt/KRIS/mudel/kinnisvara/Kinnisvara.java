package ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara;

import java.util.UUID;

public class Kinnisvara {

    private int mRegistriosaNr;
    private String mKinnisvaraNimi;
    private String mAadress;
    private UUID mOmanikuId;
    private int mVaartusEur;

    public Kinnisvara(int registriosaNr, String kinnisvaraNimi, String aadress, UUID omanik, int vaartusEur) {
        mRegistriosaNr = registriosaNr;
        mKinnisvaraNimi = kinnisvaraNimi;
        mAadress = aadress;
        mOmanikuId = omanik;
        mVaartusEur = vaartusEur;
    }

    public int saaRegistriosaNr() {
        return mRegistriosaNr;
    }

    public String saaRegistriosaNrStringina() {
        return String.valueOf(mRegistriosaNr);
    }

    public String saaKinnisvaraNimi() {
        return mKinnisvaraNimi;
    }

    public UUID saaOmanikuId() {
        return mOmanikuId;
    }

    public void maaraOmanikuId(UUID omanikuId) {
        mOmanikuId = omanikuId;
    }
}
