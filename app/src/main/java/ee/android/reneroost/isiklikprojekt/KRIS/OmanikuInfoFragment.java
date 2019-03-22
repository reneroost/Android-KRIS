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

    private static final String ARGUMENT_OMANIK = "omanik";

    public static OmanikuInfoFragment uusInstants(String omanik) {
        Bundle argumendid = new Bundle();
        argumendid.putSerializable(ARGUMENT_OMANIK, omanik);

        OmanikuInfoFragment fragment = new OmanikuInfoFragment();
        fragment.setArguments(argumendid);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View vaade = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialoog_omaniku_info, null);
        TextView omanikuNimiTekstiVaade = (TextView) vaade.findViewById(R.id.dialoog_omaniku_nimi_tekstivali);
        String omanik = (String) getArguments().getString(ARGUMENT_OMANIK);
        omanikuNimiTekstiVaade.setText(omanik);

        return new AlertDialog.Builder(getActivity())
                .setView(vaade)
                .setTitle(R.string.omaniku_info_pealkiri)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
