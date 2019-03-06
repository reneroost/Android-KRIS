package ee.android.reneroost.isiklikprojekt.KRIS;

public class Kohtunikuabi extends Kasutaja {

    // erinevad oigused, mida halduritel pole
    // boolean saab muuta omanikku = true
    // boolean ja nii edasi
    boolean onKohtunikuabi = true;

    public Kohtunikuabi(String nimi, boolean sugu, boolean juukseVarv) {
        super(nimi, sugu, juukseVarv);
    }

}
