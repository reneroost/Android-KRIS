package ee.android.reneroost.isiklikprojekt.KRIS;

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

import java.util.List;

public class KohtunikuabiValikFragment extends Fragment {

    private static final String SILT = "KohtuabiValikFragment";

    private List<Kasutaja> kasutajad = KasutajadSingleton.saaInstants(getContext()).saaKasutajad();
    int kohtunikeabisid = 19;


    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        RecyclerView kohtunikuabiTaaskasutaja = (RecyclerView) taispuhuja.inflate(
                R.layout.fragment_rolli_valimine, konteiner, false);

        String[] kohtunikeabideNimed = new String[kohtunikeabisid];
        int[] kohtunikeabidePildid = new int[kohtunikeabisid];
        Kasutaja kasutaja;
        for(int i = 0, j = 0; i < kasutajad.size(); i++) {
            kasutaja = kasutajad.get(i);
            if (kasutaja.saaAmet() == 0 || kasutaja.saaAmet() == 0) {
                kohtunikeabideNimed[j] = kasutaja.saaNimi();
                kohtunikeabidePildid[j] = kasutaja.saaPildiRessursiId();
                j++;
            }
        }

        KasutajaKirjeldusAdapter adapter = new KasutajaKirjeldusAdapter(kohtunikeabideNimed, kohtunikeabidePildid);
        kohtunikuabiTaaskasutaja.setAdapter(adapter);

        LinearLayoutManager paigutuseHaldur = new LinearLayoutManager(getActivity());
        kohtunikuabiTaaskasutaja.setLayoutManager(paigutuseHaldur);

        return kohtunikuabiTaaskasutaja;
    }

}

