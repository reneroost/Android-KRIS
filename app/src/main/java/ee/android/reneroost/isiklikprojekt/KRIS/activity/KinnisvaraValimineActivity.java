package ee.android.reneroost.isiklikprojekt.KRIS.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ee.android.reneroost.isiklikprojekt.KRIS.fragment.KinnisvaraValimineFragment;
import ee.android.reneroost.isiklikprojekt.KRIS.R;

public class KinnisvaraValimineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragment_konteiner);
        if (fragment == null) {
            fragment = new KinnisvaraValimineFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragment_konteiner, fragment)
                    .commit();
        }
    }
}
