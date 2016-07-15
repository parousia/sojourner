package com.android.sojourner;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Joseph on 7/15/16.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    private static final int TAB_POSITION_JOURNEY = 0;
    private static final int TAB_POSITION_TIMELINE = 1;
    private static final int TAB_POSITION_PRAYER = 2;

    private Context mContext;
    private TabLayout mTabLayout;

    public TabPagerAdapter(FragmentManager manager, TabLayout tabLayout, Context context) {
        super(manager);
        mContext = context;
        mTabLayout = tabLayout;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        switch (position) {
            case TAB_POSITION_JOURNEY:
                fragment = JourneyFragment.newInstance();
                break;
            case TAB_POSITION_TIMELINE:
                fragment = TimelineFragment.newInstance();
                break;
            case TAB_POSITION_PRAYER:
                fragment = PrayerTipFragment.newInstance();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
