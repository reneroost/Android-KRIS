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

    private static final String SILT = "KohtunikuabiValikFragment";

    private RecyclerView mRolliValikTaaskasutajaVaade;
    private KohtunikuabiValikFragment.RolliAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {
        View vaade = taispuhuja.inflate(R.layout.fragment_rolli_valik, konteiner, false);

        mRolliValikTaaskasutajaVaade = (RecyclerView) vaade.findViewById(R.id.roll_taaskasutaja_vaade);
        mRolliValikTaaskasutajaVaade.setLayoutManager(new LinearLayoutManager(getActivity()));

        uuendaUI();

        Log.w(SILT, "fragment kaivitus");
        return vaade;
    }

    private void uuendaUI() {
        Haldurid haldurid = Haldurid.saa(getActivity());
        List<Haldur> halduriteNimekiri = haldurid.saaHaldurid();

        mAdapter = new KohtunikuabiValikFragment.RolliAdapter(halduriteNimekiri);
        mRolliValikTaaskasutajaVaade.setAdapter(mAdapter);
    }

    private class RolliHoidja extends RecyclerView.ViewHolder {

        private Haldur mHaldur;

        private TextView mNimiTekstivaade;
        private TextView mRollTekstivaade;

        public RolliHoidja(LayoutInflater taispuhuja, ViewGroup vanem) {
            super(taispuhuja.inflate(R.layout.nimekirja_uksus_roll, vanem, false));

            mNimiTekstivaade = (TextView) itemView.findViewById(R.id.kasutaja_nimi_tekstivaade);
            mRollTekstivaade = (TextView) itemView.findViewById(R.id.kasutaja_roll_tekstivaade);
        }

        public void seo(Haldur haldur) {
            mHaldur = haldur;
            mNimiTekstivaade.setText(mHaldur.saaNimi());
            mRollTekstivaade.setText(mHaldur.saaRoll());
        }
    }

    private class RolliAdapter extends RecyclerView.Adapter<KohtunikuabiValikFragment.RolliHoidja> {
        private List<Haldur> mHaldurid;

        public RolliAdapter(List<Haldur> haldurid) {
            mHaldurid = haldurid;
        }


        @NonNull
        @Override
        public KohtunikuabiValikFragment.RolliHoidja onCreateViewHolder(@NonNull ViewGroup vanem, int i) {
            LayoutInflater paigutuseTaispuhuja = LayoutInflater.from(getActivity());

            return new KohtunikuabiValikFragment.RolliHoidja(paigutuseTaispuhuja, vanem);
        }

        @Override
        public void onBindViewHolder(@NonNull KohtunikuabiValikFragment.RolliHoidja rolliHoidja, int positsioon) {
            Haldur haldur = mHaldurid.get(positsioon);
            rolliHoidja.seo(haldur);
        }

        @Override
        public int getItemCount() {
            return mHaldurid.size();
        }
    }
}

