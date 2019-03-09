package ee.android.reneroost.isiklikprojekt.KRIS;

import android.app.Activity;
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
import android.widget.TextView;

import java.util.List;

public class AvalehtFragment extends Fragment implements View.OnClickListener{

    private static final String SILT = "AvalehtFragment";
    public static final int KUTSUNGI_KOOD_ROLL = 1;
    int valitudHaldur = 0;

    private List<Kasutaja> kasutajad = KasutajadSingleton.saaInstants(getContext()).saaKasutajad();

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        View vaade = taispuhuja.inflate(R.layout.fragment_avaleht, konteiner, false);

        TextView kasutajaNimiTekstiVaade = (TextView) vaade.findViewById(R.id.kasutaja_nimi_tekstivaade);
        kasutajaNimiTekstiVaade.setText(kasutajad.get(valitudHaldur).saaNimi());

        TextView kasutajaRollTekstiVaade = (TextView) vaade.findViewById(R.id.kasutaja_roll_tekstivaade);
        kasutajaRollTekstiVaade.setText(kasutajad.get(valitudHaldur).saaAmetStringina());

        Button muudaRolliNupp = (Button) vaade.findViewById(R.id.muuda_valitud_kasutajat_nupp);
        muudaRolliNupp.setOnClickListener(this);

        Log.w(SILT, "fragment kaivitus");
        return vaade;
    }


    @Override
    public void onClick(View vaade) {

        Intent kavatsus = new Intent(getActivity(), RolliValimineActivity.class);
        startActivityForResult(kavatsus, KUTSUNGI_KOOD_ROLL);
    }

    @Override
    public void onActivityResult(int kutsungKood, int vastusKood, Intent kavatsus) {
        if(kutsungKood == KUTSUNGI_KOOD_ROLL) {
            if(vastusKood == Activity.RESULT_OK) {
                Log.w(SILT,  kavatsus.getExtras().getString(HalduriValikFragment.EKSTRA_ROLLI_NIMI));
                valitudHaldur = kavatsus.getExtras().getInt((HalduriValikFragment.EKSTRA_ROLLI_ID));
                getFragmentManager().beginTransaction().detach(this).attach(this).commit();
            }
        }
    }

    public void asendaFragment(Fragment moniFragment) {
        FragmentManager fragmendiHaldur = getActivity().getSupportFragmentManager();
        FragmentTransaction ulekanne = fragmendiHaldur.beginTransaction();
        ulekanne.replace(R.id.fragment_konteiner, moniFragment);
        ulekanne.addToBackStack(null);
        ulekanne.commit();
    }
}
