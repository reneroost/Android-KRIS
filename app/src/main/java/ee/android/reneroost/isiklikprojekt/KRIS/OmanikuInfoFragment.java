package ee.android.reneroost.isiklikprojekt.KRIS;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class OmanikuInfoFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.omaniku_info_pealkiri)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
