package com.android.sojourner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Joseph on 7/22/16.
 */

public class TrekFragment extends Fragment {

    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trek, container, false);

        // Set up viewpager
        mViewPager = (ViewPager) v.findViewById(R.id.fragment_trek_viewPager);

        return v;
    }
}
