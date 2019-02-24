package ee.android.reneroost.isiklikprojekt.KRIS;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AvalehtFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        View vaade = taispuhuja.inflate(R.layout.fragment_avaleht, konteiner, false);

        return vaade;
    }

}
