package ee.android.reneroost.isiklikprojekt.KRIS.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

import ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara.Kinnisvara;
import ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara.KinnisvaradSingleton;
import ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara.Omanik;
import ee.android.reneroost.isiklikprojekt.KRIS.mudel.kinnisvara.OmanikudSingleton;
import ee.android.reneroost.isiklikprojekt.KRIS.R;

public class OmanikuValimineFragment extends Fragment {

    public static final String EKSTRA_OMANIKU_ID = "ee.android.reneroost.isiklikprojekt.KRIS.omaniku_id";

    private RecyclerView mOmanikuTaaskasutajaVaade;
    private OmanikuValimineFragment.OmanikuAdapter mAdapter;

    private List<Kinnisvara> kinnisvarad = KinnisvaradSingleton.saaInstants().saaKinnisvarad();

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner,
                             Bundle savedInstanceState) {
        View vaade = taispuhuja.inflate(R.layout.fragment_nimekirjast_valimine, konteiner, false);

        mOmanikuTaaskasutajaVaade = vaade.findViewById(R.id.nimekirjast_valimine_taaskasutaja_vaade);
        mOmanikuTaaskasutajaVaade.setLayoutManager(new LinearLayoutManager(getActivity()));

        uuendaUI();

        return vaade;
    }


    private void uuendaUI() {
        OmanikudSingleton omanikudSingleton = OmanikudSingleton.saaInstants();
        List<Omanik> omanikud = omanikudSingleton.saaOmanikud();

        mAdapter = new OmanikuValimineFragment.OmanikuAdapter(omanikud);
        mOmanikuTaaskasutajaVaade.setAdapter(mAdapter);
    }


    private class OmanikuHoidja extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Omanik mOmanik;

        private TextView mOmanikuNimiTekstiVaade;
        private TextView mOmanikuIsikukoodiTekstiVaade;

        public OmanikuHoidja(LayoutInflater taispuhuja, ViewGroup vanem) {
            super(taispuhuja.inflate(R.layout.kaart_omaniku_kirjeldus, vanem, false));
            itemView.setOnClickListener(this);
            mOmanikuNimiTekstiVaade = itemView.findViewById(R.id.omaniku_koosnimi_teksti_vaade);
            mOmanikuIsikukoodiTekstiVaade = itemView.findViewById(R.id.omaniku_isikukood_teksti_vaade);
        }

        public void seo(Omanik omanik) {
            mOmanik = omanik;
            mOmanikuNimiTekstiVaade.setText(mOmanik.saaKoosNimi());
            mOmanikuIsikukoodiTekstiVaade.setText(mOmanik.saaIsikukoodStringina());
        }

        @Override
        public void onClick(View vaade) {
            Toast.makeText(getActivity(),
                    mOmanik.saaKoosNimi() + getResources().getString(R.string.valitud), Toast.LENGTH_LONG)
                    .show();

            int kinnisvaraRO = getActivity().getIntent().getIntExtra("valitudKinnisvaraRO", 0);
            for (Kinnisvara kinnisvara: kinnisvarad) {
                if (kinnisvara.saaRegistriosaNr() == kinnisvaraRO) {
                    kinnisvara.maaraOmanikuId(mOmanik.saaId());
                }
            }

            Intent andmed = new Intent();
            //andmed.putExtra(EKSTRA_OMANIKU_ID, mOmanik.saaId().toString());
            Objects.requireNonNull(getActivity()).setResult(Activity.RESULT_OK, andmed);
            getActivity().finish();
        }
    }

    private class OmanikuAdapter extends RecyclerView.Adapter<OmanikuValimineFragment.OmanikuHoidja> {

        private List<Omanik> mOmanikud;

        public OmanikuAdapter(List<Omanik> omanikud) {
            mOmanikud = omanikud;
        }

        @NonNull
        @Override
        public OmanikuValimineFragment.OmanikuHoidja onCreateViewHolder(@NonNull ViewGroup vanem, int vaateTuup) {
            LayoutInflater paigutuseTaispuhuja = LayoutInflater.from(getActivity());

            return new OmanikuValimineFragment.OmanikuHoidja(paigutuseTaispuhuja, vanem);
        }

        @Override
        public void onBindViewHolder(@NonNull OmanikuValimineFragment.OmanikuHoidja omanikuHoidja, int positsioon) {
            Omanik omanik = mOmanikud.get(positsioon);
            omanikuHoidja.seo(omanik);
        }

        @Override
        public int getItemCount() {
            return mOmanikud.size();
        }
    }

}
