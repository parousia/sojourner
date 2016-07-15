package com.android.sojourner;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find TabLayout
        mTabLayout = (TabLayout) findViewById(R.id.main_activity_tabLayout);

        // Create PagerAdapter
        mPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), mTabLayout);

        // Find ViewPager
        mViewPager = (ViewPager) findViewById(R.id.container_viewPager);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mPagerAdapter);

        // Set up TabLayout
        mTabLayout.setupWithViewPager(mViewPager);
        mPagerAdapter.setTabIcons();
    }
}
