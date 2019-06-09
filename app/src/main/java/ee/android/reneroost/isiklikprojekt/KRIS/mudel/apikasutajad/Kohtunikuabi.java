package ee.android.reneroost.isiklikprojekt.KRIS.mudel.apikasutajad;

public class Kohtunikuabi extends Kasutaja {

    // Kohtunikeabidel saavad olema erinevad lisa-oigused, mida halduritel pole
    boolean onKohtunikuabi = true;

    public Kohtunikuabi(String nimi, int amet, int emojiId, boolean sugu, boolean juukseVarv) {
        super(nimi, amet, emojiId, sugu, juukseVarv);
    }

    public String saaRoll() {
        return "kohtunikuabi";
    }

}
