package ee.android.reneroost.isiklikprojekt.KRIS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class AvalehtFragment extends Fragment implements View.OnClickListener{

    private static final String SILT = "AvalehtFragment";
    public static final int KUTSUNG_KOOD_ROLL = 1;
    public static final int KUTSUNG_KOOD_KINNISVARA = 2;

    int valitudHaldur = 0;
    int valitudKinnisvaraRO = 81588;

    private List<Kasutaja> kasutajad = KasutajadSingleton.saaInstants().saaKasutajad();
    private List<Kinnisvara> kinnisvarad = KinnisvaradSingleton.saaInstants().saaKinnisvarad();

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        View vaade = taispuhuja.inflate(R.layout.fragment_avaleht, konteiner, false);


        // Kasutaja valimine
        TextView kasutajaNimiTekstiVaade = (TextView) vaade.findViewById(R.id.kasutaja_nimi_tekstivaade);
        kasutajaNimiTekstiVaade.setText(kasutajad.get(valitudHaldur).saaNimi());

        TextView kasutajaRollTekstiVaade = (TextView) vaade.findViewById(R.id.kasutaja_roll_tekstivaade);
        kasutajaRollTekstiVaade.setText(kasutajad.get(valitudHaldur).saaAmetStringina());

        Button vahetaRolliNupp = (Button) vaade.findViewById(R.id.muuda_valitud_kasutajat_nupp);
        vahetaRolliNupp.setOnClickListener(this);


        // Kinnisvara valimine
        for (Kinnisvara kinnisvara: kinnisvarad) {
            if (kinnisvara.saaRegistriosaNr() == valitudKinnisvaraRO) {
                TextView kinnisvaraNimiTekstiVaade = (TextView) vaade.findViewById(R.id.kinnisvara_teksti_vaade);
                kinnisvaraNimiTekstiVaade.setText(kinnisvara.saaKinnisvaraNimi());
            }
        }

        Button vahetaKinnisvaraNupp = (Button) vaade.findViewById(R.id.muuda_valitud_kinnisvara_nupp);
        vahetaKinnisvaraNupp.setOnClickListener(this);

        return vaade;
    }


    @Override
    public void onClick(View vaade) {
        Intent kavatsus;
        switch(vaade.getId()) {
            case R.id.muuda_valitud_kasutajat_nupp:
                kavatsus = new Intent(getActivity(), RolliValimineActivity.class);
                startActivityForResult(kavatsus, KUTSUNG_KOOD_ROLL);
                break;
            case R.id.muuda_valitud_kinnisvara_nupp:
                kavatsus = new Intent(getActivity(), KinnisvaraValimineActivity.class);
                startActivityForResult(kavatsus, KUTSUNG_KOOD_KINNISVARA);
                break;
        }
    }

    @Override
    public void onActivityResult(int kutsungKood, int vastusKood, Intent kavatsus) {
        if(kutsungKood == KUTSUNG_KOOD_ROLL) {
            if (vastusKood == Activity.RESULT_OK) {
                valitudHaldur = kavatsus.getExtras().getInt(RolliValimineFragment.EKSTRA_ROLLI_ID);
                getFragmentManager().beginTransaction().detach(this).attach(this).commit();
            }
        } else if (kutsungKood == KUTSUNG_KOOD_KINNISVARA) {
            if (vastusKood == Activity.RESULT_OK) {
                valitudKinnisvaraRO = kavatsus.getExtras().getInt(KinnisvaraValimineFragment.EKSTRA_KINNISVARA_RO);
                getFragmentManager().beginTransaction().detach(this).attach(this).commit();
            }
        }
    }

}
