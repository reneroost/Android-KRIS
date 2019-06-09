package ee.android.reneroost.isiklikprojekt.KRIS.kontroller;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ee.android.reneroost.isiklikprojekt.KRIS.R;

public class KasutajaKirjeldusAdapter extends RecyclerView.Adapter<KasutajaKirjeldusAdapter.VaateHoidja> {

    private String[] nimi;
    private int[] pildiId;
    private Listener kuular;

    public interface Listener {
        void onClick(int positsioon);
    }

    public static class VaateHoidja extends RecyclerView.ViewHolder {

        private CardView kaardiVaade;

        public VaateHoidja(CardView vaade) {
            super(vaade);
            kaardiVaade = vaade;
        }

    }

    public KasutajaKirjeldusAdapter(String[] nimi, int[] pildiId) {
        this.nimi = nimi;
        this.pildiId = pildiId;
    }

    public void maaraListener(Listener kuular) {
        this.kuular = kuular;
    }

    @Override
    public int getItemCount() {
        return nimi.length;
    }

    @Override
    public KasutajaKirjeldusAdapter.VaateHoidja onCreateViewHolder(ViewGroup vanem, int vaateTuup) {
        CardView kaardiVaade = (CardView) LayoutInflater.from(vanem.getContext())
                .inflate(R.layout.kaart_kasutaja_kirjeldus, vanem, false);
        return new VaateHoidja(kaardiVaade);
    }

    @Override
    public void onBindViewHolder(VaateHoidja hoidja, final int positsioon) {
        CardView kaardiVaade = hoidja.kaardiVaade;
        ImageView pildiVaade = kaardiVaade.findViewById(R.id.kasutaja_pilt);
        Drawable joonistatav = ContextCompat.getDrawable(kaardiVaade.getContext(), pildiId[positsioon]);
        pildiVaade.setImageDrawable(joonistatav);
        TextView tekstiVaade = kaardiVaade.findViewById(R.id.kasutaja_nimi);
        tekstiVaade.setText(nimi[positsioon]);

        kaardiVaade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kuular != null) {
                    kuular.onClick(positsioon);
                }
            }
        });
    }
}
