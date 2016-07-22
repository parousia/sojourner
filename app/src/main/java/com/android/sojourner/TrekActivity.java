package com.android.sojourner;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Joseph on 7/22/16.
 */

public class TrekActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TrekFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
