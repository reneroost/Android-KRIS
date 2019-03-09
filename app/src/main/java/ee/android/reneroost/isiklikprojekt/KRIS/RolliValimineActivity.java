package ee.android.reneroost.isiklikprojekt.KRIS;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class RolliValimineActivity extends AppCompatActivity {

    private static final String SILT = "RolliVaimineActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolli_valimine);

        android.support.v7.widget.Toolbar tooriistariba = (Toolbar) findViewById(R.id.tooriistariba);
        setSupportActionBar(tooriistariba);
        tooriistariba.setTitle(looTooriistaribaPealkiri());

        RollidPagerAdapter pagerAdapter = new RollidPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout vaheleheLayout = (TabLayout) findViewById(R.id.vahelehed);
        vaheleheLayout.setupWithViewPager(pager);
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


    private class RollidPagerAdapter extends FragmentPagerAdapter {

        public RollidPagerAdapter(FragmentManager fragmendiHaldur) {
            super(fragmendiHaldur);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int positsioon) {
            return RolliValimineFragment.uusInstants(positsioon);
        }

        @Override
        public CharSequence getPageTitle(int positsioon) {
            switch(positsioon) {
                case 0:
                    return getResources().getText(R.string.kohtunikuabid_vaheleht);
                case 1:
                    return getResources().getText(R.string.haldurid_vaheleht);
                case 2:
                    return getResources().getText(R.string.halduriabid_vaheleht);

            }
            return null;
        }
    }
}
