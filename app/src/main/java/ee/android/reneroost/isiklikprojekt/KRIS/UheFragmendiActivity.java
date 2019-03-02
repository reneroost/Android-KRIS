package ee.android.reneroost.isiklikprojekt.KRIS;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class UheFragmendiActivity extends AppCompatActivity {

    protected abstract Fragment looFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragment_konteiner);

        if(fragment == null) {
            fragment = looFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragment_konteiner, fragment)
                    .commit();
        }
    }

}
