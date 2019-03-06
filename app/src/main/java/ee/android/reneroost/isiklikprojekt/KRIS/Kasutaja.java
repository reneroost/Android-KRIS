package ee.android.reneroost.isiklikprojekt.KRIS;

public class Kasutaja {

    private String mNimi;

    // sugu ja juuksevärv on õige emoji kuvamiseks
    private boolean mSugu;               // naine = true,    mees = false
    private boolean mJuukseVarv;        // brünett = true,  blond = false

    public Kasutaja(String nimi, boolean sugu, boolean juukseVarv) {
        mNimi = nimi;
        mSugu = sugu;
        mJuukseVarv = juukseVarv;
    }

    public String saaNimi() {
        return mNimi;
    }

    public boolean saaSugu() {
        return mSugu;
    }

    public boolean saaJuukseVarv() {
        return mJuukseVarv;
    }
}
