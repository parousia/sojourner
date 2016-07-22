package com.android.sojourner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by Joseph on 7/22/16.
 */

public class SlideActivity extends AppCompatActivity implements SlideFragment.SlideContainer {
    private static final String EXTRA_SCENE_NUMBER = "extra_scene_number";
    private ViewPager mViewPager;
    private Scene mScene;
    private List<Slide> mSlides;

    public static Intent newIntent(Context context, int sceneNum) {
        Intent i = new Intent(context, SlideActivity.class);
        i.putExtra(EXTRA_SCENE_NUMBER, sceneNum);
        return i;
    }

    @Override
    public Slide getSlideFromContainer(int slideNum) {
        return mSlides.get(slideNum);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        // Get scene and slides
        int sceneNum = getIntent().getIntExtra(EXTRA_SCENE_NUMBER, 0);
        mScene = SceneLab.get(this).getScene(sceneNum);
        mSlides = mScene.getSlides();

        // Set up viewpager
        mViewPager = (ViewPager) findViewById(R.id.activity_trek_viewPager);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                SlideFragment fragment = SlideFragment.newInstance(position);
                fragment.setSlideContainer(SlideActivity.this);
                return fragment;
            }

            @Override
            public int getCount() {
                return mSlides.size();
            }
        });
    }
}
