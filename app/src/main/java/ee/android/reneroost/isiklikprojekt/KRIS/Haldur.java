package ee.android.reneroost.isiklikprojekt.KRIS;

public class Haldur extends Kasutaja {

    private boolean mPohiHaldur;

    public Haldur(String nimi, int amet, int emojiId, boolean sugu, boolean juukseVarv, boolean pohiHaldur){
        super(nimi, amet, emojiId, sugu, juukseVarv);
        mPohiHaldur = pohiHaldur;
    }

    public String saaRoll() {
        if (mPohiHaldur) {
            return "haldur";
        } else {
            return "halduri abi";
        }
    }

}
