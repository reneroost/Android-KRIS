package ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara;

import java.util.UUID;

public class Omanik {

    private UUID mId;
    private String mKoosNimi;
    private long mIsikukood;
    private int mRahvus;         // 0 - eestlane, 1 - venelane, 2 - soomlane

    public Omanik(String koosNimi, long isikukood, int rahvus) {
        mId = UUID.randomUUID();
        mKoosNimi = koosNimi;
        mIsikukood = isikukood;
        mRahvus = rahvus;
    }

    public UUID saaId() {
        return mId;
    }

    public String saaKoosNimi() {
        return mKoosNimi;
    }

    public long saaIsikukood() {
        return mIsikukood;
    }

    public String saaIsikukoodStringina() {
        return String.valueOf(mIsikukood);
    }

    public int saaRahvus() {
        return mRahvus;
    }
}
