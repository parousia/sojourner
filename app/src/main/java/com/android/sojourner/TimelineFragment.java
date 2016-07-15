package com.android.sojourner;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Joseph on 7/15/16.
 */

public class TimelineFragment extends Fragment {

    public static TimelineFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TimelineFragment fragment = new TimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
