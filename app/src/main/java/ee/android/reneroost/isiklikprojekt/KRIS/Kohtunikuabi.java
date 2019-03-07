package ee.android.reneroost.isiklikprojekt.KRIS;

public class Kohtunikuabi extends Kasutaja {

    // erinevad oigused, mida halduritel pole
    // boolean saab muuta omanikku = true
    // boolean ja nii edasi
    boolean onKohtunikuabi = true;

    public Kohtunikuabi(String nimi, int emojiId, boolean sugu, boolean juukseVarv) {
        super(nimi, emojiId, sugu, juukseVarv);
    }

    public String saaRoll() {
        return "kohtunikuabi";
    }

}
