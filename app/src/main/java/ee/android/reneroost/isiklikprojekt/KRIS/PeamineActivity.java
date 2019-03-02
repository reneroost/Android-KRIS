package ee.android.reneroost.isiklikprojekt.KRIS;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class PeamineActivity extends AppCompatActivity {

    private static final String SILT = "PeamineActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peamine);

        Toolbar tooriistariba = (Toolbar) findViewById(R.id.tooriistariba);
        setSupportActionBar(tooriistariba);
        tooriistariba.setTitle(looTooriistaribaPealkiri());

        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragment_konteiner);

        if(fragment == null) {
            fragment = new AvalehtFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragment_konteiner, fragment)
                    .commit();
        }

    }




    private String looTooriistaribaPealkiri() {
        return getString(R.string.app_name) + " " + saaVersiooniNumberStringina().substring(0, 3);
    }

    private String saaVersiooniNumberStringina() {
        String versiooniNumberStringina = "";
        try {
            PackageInfo pakiInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
            versiooniNumberStringina = pakiInfo.versionName;
        } catch (PackageManager.NameNotFoundException nimeEiLeiaErind) {
            Log.w("PeamineActivity", "Nime ei leia" + nimeEiLeiaErind);
        }
        return versiooniNumberStringina;
    }
}
