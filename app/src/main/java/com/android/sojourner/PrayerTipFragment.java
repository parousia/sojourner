package com.android.sojourner;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Joseph on 7/15/16.
 */

public class PrayerTipFragment extends Fragment {

    public static PrayerTipFragment newInstance() {

        Bundle args = new Bundle();

        PrayerTipFragment fragment = new PrayerTipFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
