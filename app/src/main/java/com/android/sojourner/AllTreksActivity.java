package com.android.sojourner;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Joseph on 7/22/16.
 */

public class AllTreksActivity extends SingleFragmentActivity {

    private Toolbar mToolbar;

    @Override
    protected AllTreksFragment createFragment() {
        return new AllTreksFragment();
    }

    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_all_treks;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the Toolbar and enable ancestral navigation
        mToolbar = (Toolbar) findViewById(R.id.all_treks_activity_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
