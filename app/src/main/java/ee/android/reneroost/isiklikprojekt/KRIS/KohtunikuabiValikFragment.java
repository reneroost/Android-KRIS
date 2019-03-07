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


    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        RecyclerView kohtunikuabiTaaskasutaja = (RecyclerView) taispuhuja.inflate(
                R.layout.fragment_rolli_valimine, konteiner, false);

        String[] kohtunikeabideNimed = new String[Kohtunikuabid.saa(getActivity()).saaKohtunikuabid().size()];
        for(int i = 0; i < kohtunikeabideNimed.length; i++) {
            kohtunikeabideNimed[i] = Kohtunikuabid.saa(getActivity()).saaKohtunikuabid().get(i).saaNimi();
        }

        int[] kohtunikeabidePildid = new int[Kohtunikuabid.saa(getActivity()).saaKohtunikuabid().size()];
        for(int i = 0; i < kohtunikeabidePildid.length; i++) {
            kohtunikeabidePildid[i] = Kohtunikuabid.saa(getActivity()).saaKohtunikuabid().get(i).saaPildiRessursiId();
        }

        KasutajaKirjeldusAdapter adapter = new KasutajaKirjeldusAdapter(kohtunikeabideNimed, kohtunikeabidePildid);
        kohtunikuabiTaaskasutaja.setAdapter(adapter);

        LinearLayoutManager paigutuseHaldur = new LinearLayoutManager(getActivity());
        kohtunikuabiTaaskasutaja.setLayoutManager(paigutuseHaldur);

        return kohtunikuabiTaaskasutaja;
    }

}

