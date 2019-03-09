package ee.android.reneroost.isiklikprojekt.KRIS;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HalduriValikFragment extends Fragment {

    private static final String SILT = "HalduriValikFragment";
    public static final String EKSTRA_ROLLI_NIMI = "ee.android.reneroost.isiklikprojekt.KRIS.rolli_nimi";
    public static final String EKSTRA_ROLLI_ID = "ee.android.reneroost.isiklikprojekt.KRIS.rolli_id";

    private List<Kasutaja> kasutajad = KasutajadSingleton.saaInstants(getContext()).saaKasutajad();
    int haldureid = 7;

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        RecyclerView halduriTaaskasutaja = (RecyclerView) taispuhuja.inflate(
                R.layout.fragment_rolli_valimine, konteiner, false);

        String[] halduriteNimed = new String[haldureid];
        int[] halduritePildid = new int[haldureid];
        Kasutaja kasutaja;
        for(int i = 0, j = 0; i < kasutajad.size(); i++) {
            kasutaja = kasutajad.get(i);
            if (kasutaja.saaAmet() == 1 || kasutaja.saaAmet() == 2) {
                halduriteNimed[j] = kasutaja.saaNimi();
                halduritePildid[j] = kasutaja.saaPildiRessursiId();
                j++;
            }
        }

        KasutajaKirjeldusAdapter adapter = new KasutajaKirjeldusAdapter(halduriteNimed, halduritePildid);
        halduriTaaskasutaja.setAdapter(adapter);

        LinearLayoutManager paigutuseHaldur = new LinearLayoutManager(getActivity());
        halduriTaaskasutaja.setLayoutManager(paigutuseHaldur);

        adapter.maaraListener(new KasutajaKirjeldusAdapter.Listener() {
            @Override
            public void onClick(int positsioon) {

                Toast rost = Toast.makeText(getContext(), "valisid halduri", Toast.LENGTH_SHORT);
                rost.show();
                Intent andmed = new Intent();
                andmed.putExtra(EKSTRA_ROLLI_ID, positsioon);
                andmed.putExtra(EKSTRA_ROLLI_NIMI, kasutajad.get(positsioon).saaNimi());
                getActivity().setResult(Activity.RESULT_OK, andmed);
            }
        });

        return halduriTaaskasutaja;
    }

}
