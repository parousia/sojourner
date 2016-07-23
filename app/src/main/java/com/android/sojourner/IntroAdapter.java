package com.android.sojourner;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jlian on 7/22/2016.
 */
public class IntroAdapter extends FragmentPagerAdapter {

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(Color.parseColor("#03A9F4"), position);
            case 1:
                return IntroFragment.newInstance(Color.parseColor("#4CAF50"), position);
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

}
