package ee.android.reneroost.isiklikprojekt.KRIS.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

import ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara.Kinnisvara;
import ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara.KinnisvaradSingleton;
import ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara.OmanikudSingleton;
import ee.android.reneroost.isiklikprojekt.KRIS.R;
import ee.android.reneroost.isiklikprojekt.KRIS.activity.KinnisvaraValimineActivity;
import ee.android.reneroost.isiklikprojekt.KRIS.activity.OmanikuValimineActivity;
import ee.android.reneroost.isiklikprojekt.KRIS.activity.RolliValimineActivity;
import ee.android.reneroost.isiklikprojekt.KRIS.mudel.apikasutajad.Kasutaja;
import ee.android.reneroost.isiklikprojekt.KRIS.mudel.apikasutajad.KasutajadSingleton;

public class AvalehtFragment extends Fragment implements View.OnClickListener{

    //private static final String SILT = "AvalehtFragment";
    private static final String DIALOOG_OMANIK = "DialoogOmanik";

    public static final int KUTSUNG_KOOD_ROLL = 1;
    public static final int KUTSUNG_KOOD_KINNISVARA = 2;
    public static final int KUTSUNG_KOOD_OMANIKU_VAHETUS = 3;

    int valitudHaldur = 0;
    int valitudKinnisvaraRO = 81588;

    private List<Kasutaja> kasutajad = KasutajadSingleton.saaInstants().saaKasutajad();
    private List<Kinnisvara> kinnisvarad = KinnisvaradSingleton.saaInstants().saaKinnisvarad();

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        View vaade = taispuhuja.inflate(R.layout.fragment_avaleht, konteiner, false);


        // Kasutaja info ja muu kasutaja valimine
        TextView kasutajaNimiTekstiVaade = vaade.findViewById(R.id.kasutaja_nimi_tekstivaade);
        kasutajaNimiTekstiVaade.setText(kasutajad.get(valitudHaldur).saaNimi());

        TextView kasutajaRollTekstiVaade = vaade.findViewById(R.id.kasutaja_roll_tekstivaade);
        kasutajaRollTekstiVaade.setText(kasutajad.get(valitudHaldur).saaAmetStringina());

        Button vahetaRolliNupp = vaade.findViewById(R.id.muuda_valitud_kasutajat_nupp);
        vahetaRolliNupp.setOnClickListener(this);


        // Kinnisvara info ja muu kinnisvara valimine
        String kinnisvaraOmanik = "";
        for (Kinnisvara kinnisvara: kinnisvarad) {
            if (kinnisvara.saaRegistriosaNr() == valitudKinnisvaraRO) {
                TextView kinnisvaraNimiTekstiVaade = vaade.findViewById(R.id.kinnisvara_nimi_teksti_vaade);
                kinnisvaraNimiTekstiVaade.setText(kinnisvara.saaKinnisvaraNimi());

                kinnisvaraOmanik = OmanikudSingleton.saaInstants().saaOmanik(kinnisvara.saaOmanikuId()).saaKoosNimi();
                TextView kinnisvaraOmanikTekstiVaade = vaade.findViewById(R.id.kinnisvara_omanik_teksti_vaade);
                kinnisvaraOmanikTekstiVaade.setText(kinnisvaraOmanik);
            }
        }
        Button vahetaKinnisvaraNupp = vaade.findViewById(R.id.muuda_valitud_kinnisvara_nupp);
        vahetaKinnisvaraNupp.setOnClickListener(this);


        // Toimingud kinnisvaraga
        ImageButton toimingVaataOmanikku = vaade.findViewById(R.id.toiming_vaata_omanikku);
        toimingVaataOmanikku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmendiHaldur = getFragmentManager();
                String kinnisvaraOmanikuNimi = "";
                String kinnisVaraOmanikuIsikukood = "";
                for (Kinnisvara kinnisvara: kinnisvarad) {
                    if (kinnisvara.saaRegistriosaNr() == valitudKinnisvaraRO) {
                        kinnisvaraOmanikuNimi = OmanikudSingleton.saaInstants().saaOmanik(kinnisvara.saaOmanikuId()).saaKoosNimi();
                        kinnisVaraOmanikuIsikukood = OmanikudSingleton.saaInstants().saaOmanik(kinnisvara.saaOmanikuId()).saaIsikukoodStringina();
                    }
                }
                OmanikuInfoFragment dialoog = OmanikuInfoFragment
                        .uusInstants(kinnisvaraOmanikuNimi, kinnisVaraOmanikuIsikukood);
                assert fragmendiHaldur != null;
                dialoog.show(fragmendiHaldur, DIALOOG_OMANIK);
            }
        });

        ImageButton toimingVahetaOmanikku = vaade.findViewById(R.id.toiming_vaheta_omanikku);
        toimingVahetaOmanikku.setOnClickListener(this);

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
            case R.id.toiming_vaheta_omanikku:
                kavatsus = new Intent(getActivity(), OmanikuValimineActivity.class);
                kavatsus.putExtra("valitudKinnisvaraRO", valitudKinnisvaraRO);
                startActivityForResult(kavatsus, KUTSUNG_KOOD_OMANIKU_VAHETUS);
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
        } else if (kutsungKood == KUTSUNG_KOOD_OMANIKU_VAHETUS) {
            if (vastusKood == Activity.RESULT_OK) {
                getFragmentManager().beginTransaction().detach(this).attach(this).commit();
            }
        }
    }

}
