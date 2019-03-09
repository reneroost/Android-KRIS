package ee.android.reneroost.isiklikprojekt.KRIS;

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

public class KinnisvaraValimineFragment extends Fragment {

    public static final String EKSTRA_KINNISVARA_RO = "ee.android.reneroost.isiklikprojekt.KRIS.kinnisvara_id";

    private RecyclerView mKinnisvaraTaaskasutajaVaade;
    private KinnisvaraAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner,
                             Bundle savedInstanceState) {
        View vaade = taispuhuja.inflate(R.layout.fragment_nimekirjast_valimine, konteiner, false);

        mKinnisvaraTaaskasutajaVaade = (RecyclerView) vaade.findViewById(R.id.nimekirjast_valimine_taaskasutaja_vaade);
        mKinnisvaraTaaskasutajaVaade.setLayoutManager(new LinearLayoutManager(getActivity()));

        uuendaUI();

        return vaade;
    }


    private void uuendaUI() {
        KinnisvaradSingleton kinnisvaradSingleton = KinnisvaradSingleton.saaInstants();
        List<Kinnisvara> kinnisvarad = kinnisvaradSingleton.saaKinnisvarad();

        mAdapter = new KinnisvaraAdapter(kinnisvarad);
        mKinnisvaraTaaskasutajaVaade.setAdapter(mAdapter);
    }


    private class KinnisvaraHoidja extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Kinnisvara mKinnisvara;

        private TextView mKinnisvaraNimiTekstiVaade;
        private TextView mRegistriosaNrTekstiVaade;
        private TextView mOmanikuNimiTekstiVaade;

        public KinnisvaraHoidja(LayoutInflater taispuhuja, ViewGroup vanem) {
            super(taispuhuja.inflate(R.layout.kaart_kinnisvara_kirjeldus, vanem, false));
            itemView.setOnClickListener(this);

            mKinnisvaraNimiTekstiVaade = (TextView) itemView.findViewById(R.id.kinnisvara_nimi_teksti_vaade);
            mRegistriosaNrTekstiVaade = (TextView) itemView.findViewById(R.id.kinnisvara_registriosanr_teksti_vaade);
            mOmanikuNimiTekstiVaade = (TextView) itemView.findViewById(R.id.kinnisvara_omanik_teksti_vaade);
        }

        public void seo(Kinnisvara kinnisvara) {
            mKinnisvara = kinnisvara;
            mKinnisvaraNimiTekstiVaade.setText(mKinnisvara.saaKinnisvaraNimi());
            mRegistriosaNrTekstiVaade.setText(mKinnisvara.saaRegistriosaNrStringina());
            mOmanikuNimiTekstiVaade.setText(mKinnisvara.saaOmanikuNimi());
        }

        @Override
        public void onClick(View vaade) {
            Toast.makeText(getActivity(),
                    mKinnisvara.saaKinnisvaraNimi() + getResources().getString(R.string.valitud), Toast.LENGTH_LONG)
                    .show();

            Intent andmed = new Intent();
            andmed.putExtra(EKSTRA_KINNISVARA_RO, mKinnisvara.saaRegistriosaNr());
            Objects.requireNonNull(getActivity()).setResult(Activity.RESULT_OK, andmed);
            getActivity().finish();
        }
    }

    private class KinnisvaraAdapter extends RecyclerView.Adapter<KinnisvaraHoidja> {

        private List<Kinnisvara> mKinnisvarad;

        public KinnisvaraAdapter(List<Kinnisvara> kinnisvarad) {
            mKinnisvarad = kinnisvarad;
        }

        @NonNull
        @Override
        public KinnisvaraHoidja onCreateViewHolder(@NonNull ViewGroup vanem, int vaateTuup) {
            LayoutInflater paigutuseTaispuhuja = LayoutInflater.from(getActivity());

            return new KinnisvaraHoidja(paigutuseTaispuhuja, vanem);
        }

        @Override
        public void onBindViewHolder(@NonNull KinnisvaraHoidja kinnisvaraHoidja, int positsioon) {
            Kinnisvara kinnisvara = mKinnisvarad.get(positsioon);
            kinnisvaraHoidja.seo(kinnisvara);
        }

        @Override
        public int getItemCount() {
            return mKinnisvarad.size();
        }
    }

}
