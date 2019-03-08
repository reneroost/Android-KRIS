package ee.android.reneroost.isiklikprojekt.KRIS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AvalehtFragment extends Fragment implements View.OnClickListener{

    private static final String SILT = "AvalehtFragment";

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        View vaade = taispuhuja.inflate(R.layout.fragment_avaleht, konteiner, false);

        Button muudaRolliNupp = (Button) vaade.findViewById(R.id.muuda_valitud_kasutajat_nupp);
        muudaRolliNupp.setOnClickListener(this);

        Log.w(SILT, "fragment kaivitus");
        return vaade;
    }

    @Override
    public void onClick(View vaade) {

        Intent kavatsus = new Intent(getActivity(), RolliValimineActivity.class);
        startActivity(kavatsus);
        /*
        Fragment fragment = null;
        switch(vaade.getId()) {
            case R.id.muuda_kasutajat_nupp:
                fragment = new KohtunikuabiValikFragment();
                asendaFragment(fragment);
                break;
        }
        */
    }

    public void asendaFragment(Fragment moniFragment) {
        FragmentManager fragmendiHaldur = getActivity().getSupportFragmentManager();
        FragmentTransaction ulekanne = fragmendiHaldur.beginTransaction();
        ulekanne.replace(R.id.fragment_konteiner, moniFragment);
        ulekanne.addToBackStack(null);
        ulekanne.commit();
    }
}
