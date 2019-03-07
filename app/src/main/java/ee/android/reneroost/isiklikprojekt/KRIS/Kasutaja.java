package ee.android.reneroost.isiklikprojekt.KRIS;

public class Kasutaja {

    private String mNimi;
    private int mEmojiId;

    // sugu ja juuksevärv on õige emoji kuvamiseks
    private boolean mSugu;               // naine = true,    mees = false
    private boolean mJuukseVarv;        // brünett = true,  blond = false

    public Kasutaja(String nimi, int emojiId, boolean sugu, boolean juukseVarv) {
        mNimi = nimi;
        mEmojiId = emojiId;
        mSugu = sugu;
        mJuukseVarv = juukseVarv;
    }

    public String saaNimi() {
        return mNimi;
    }

    public int saaPildiRessursiId() {
        return mEmojiId;
    }

    public boolean saaSugu() {
        return mSugu;
    }

    public boolean saaJuukseVarv() {
        return mJuukseVarv;
    }
}
