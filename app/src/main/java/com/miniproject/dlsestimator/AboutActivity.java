package com.miniproject.dlsestimator;

import android.support.v4.app.Fragment;

public class AboutActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return AboutFragment.newInstance();
    }
}
