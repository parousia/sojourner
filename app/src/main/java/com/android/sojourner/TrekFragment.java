package com.android.sojourner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Joseph on 7/22/16.
 */

public class TrekFragment extends Fragment {
    private static final String ARG_SCENE_NUMBER = "arg_scene_number";

    public static TrekFragment newInstance(int sceneNum) {
        Bundle args = new Bundle();
        args.putInt(ARG_SCENE_NUMBER, sceneNum);

        TrekFragment fragment = new TrekFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ViewPager mViewPager;
    private Scene mScene;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve current scene
        Bundle args = getArguments();
        int sceneNum = 0;
        if (args != null) {
            sceneNum = args.getInt(ARG_SCENE_NUMBER);
        }
        mScene = SceneLab.get(getActivity()).getScene(sceneNum);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trek, container, false);

        // Get the slides to display
        List<Slide> slides = mScene.getSlides();

        // Set up viewpager
        mViewPager = (ViewPager) v.findViewById(R.id.fragment_trek_viewPager);


        return v;
    }
}
