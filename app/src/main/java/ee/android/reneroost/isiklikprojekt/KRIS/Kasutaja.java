package ee.android.reneroost.isiklikprojekt.KRIS;

public class Kasutaja {

    private String mNimi;
    private int mAmet;       // 0 - kohtunikuabi, 1 - haldur, 2 - halduri abi
    private int mEmojiId;

    // sugu ja juuksevärv on õige emoji kuvamiseks
    private boolean mSugu;               // naine = true,    mees = false
    private boolean mJuukseVarv;        // brünett = true,  blond = false

    public Kasutaja(String nimi, int amet, int emojiId, boolean sugu, boolean juukseVarv) {
        mNimi = nimi;
        mAmet = amet;
        mEmojiId = emojiId;
        mSugu = sugu;
        mJuukseVarv = juukseVarv;
    }

    public String saaNimi() {
        return mNimi;
    }

    public int saaAmet() {
        return mAmet;
    }

    public String saaAmetStringina() {
        switch(mAmet) {
            case 0:
                return "kohtunikuabi";
            case 1:
                return "haldur";
            case 2:
                return "halduri abi";
        }
        return "vigane ameti väärtus";
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
