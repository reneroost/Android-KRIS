package ee.android.reneroost.isiklikprojekt.KRIS;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class OmanikuInfoFragment extends DialogFragment {

    private static final String ARGUMENT_OMANIKU_NIMI = "omaniku_nimi";
    private static final String ARGUMENT_OMANIKU_ISIKUKOOD = "omaniku_isikukood";

    public static OmanikuInfoFragment uusInstants(String omanikuNimi, String omanikuIsikukood) {
        Bundle argumendid = new Bundle();
        argumendid.putSerializable(ARGUMENT_OMANIKU_NIMI, omanikuNimi);
        argumendid.putSerializable(ARGUMENT_OMANIKU_ISIKUKOOD, omanikuIsikukood);

        OmanikuInfoFragment fragment = new OmanikuInfoFragment();
        fragment.setArguments(argumendid);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View vaade = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialoog_omaniku_info, null);

        TextView omanikuNimiAbiinfoTekstiVaade = (TextView) vaade.findViewById(R.id.dialoog_omaniku_nimi_abitekst_tekstivali);
        String omanikuNimiAbiinfo = getResources().getString(R.string.omaniku_nimi_abitekst);
        omanikuNimiAbiinfoTekstiVaade.setText(omanikuNimiAbiinfo);

        TextView omanikuNimiTekstiVaade = (TextView) vaade.findViewById(R.id.dialoog_omaniku_nimi_tekstivali);
        String omanikuNimi = (String) getArguments().getString(ARGUMENT_OMANIKU_NIMI);
        omanikuNimiTekstiVaade.setText(omanikuNimi);

        TextView omanikuIsikukoodAbiinfoTekstiVaade = (TextView) vaade.findViewById(R.id.dialoog_omaniku_isikukood_abitekst_tekstivali);
        String omanikuIsikukoodAbiinfo = getResources().getString(R.string.omaniku_isikukood_abitekst);
        omanikuIsikukoodAbiinfoTekstiVaade.setText(omanikuIsikukoodAbiinfo);

        TextView omanikuIsikukoodTekstiVaade = (TextView) vaade.findViewById(R.id.dialoog_omaniku_isikukood_tekstivali);
        String omanikuIsikukood = (String) getArguments().getString(ARGUMENT_OMANIKU_ISIKUKOOD);
        omanikuIsikukoodTekstiVaade.setText(omanikuIsikukood);

        return new AlertDialog.Builder(getActivity())
                .setView(vaade)
                .setTitle(R.string.omaniku_info_pealkiri)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
