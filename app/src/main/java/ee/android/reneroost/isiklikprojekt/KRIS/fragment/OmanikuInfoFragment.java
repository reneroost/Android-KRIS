package ee.android.reneroost.isiklikprojekt.KRIS.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import ee.android.reneroost.isiklikprojekt.KRIS.R;

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

        TextView omanikuNimiAbiinfoTekstiVaade = vaade.findViewById(R.id.dialoog_omaniku_nimi_abitekst_tekstivali);
        String omanikuNimiAbiinfo = getResources().getString(R.string.omaniku_nimi_abitekst);
        omanikuNimiAbiinfoTekstiVaade.setText(omanikuNimiAbiinfo);

        TextView omanikuNimiTekstiVaade = vaade.findViewById(R.id.dialoog_omaniku_nimi_tekstivali);
        String omanikuNimi = getArguments().getString(ARGUMENT_OMANIKU_NIMI);
        omanikuNimiTekstiVaade.setText(omanikuNimi);

        TextView omanikuIsikukoodAbiinfoTekstiVaade = vaade.findViewById(R.id.dialoog_omaniku_isikukood_abitekst_tekstivali);
        String omanikuIsikukoodAbiinfo = getResources().getString(R.string.omaniku_isikukood_abitekst);
        omanikuIsikukoodAbiinfoTekstiVaade.setText(omanikuIsikukoodAbiinfo);

        TextView omanikuIsikukoodTekstiVaade = vaade.findViewById(R.id.dialoog_omaniku_isikukood_tekstivali);
        String omanikuIsikukood = getArguments().getString(ARGUMENT_OMANIKU_ISIKUKOOD);
        omanikuIsikukoodTekstiVaade.setText(omanikuIsikukood);

        return new AlertDialog.Builder(getActivity())
                .setView(vaade)
                .setTitle(R.string.omaniku_info_pealkiri)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
