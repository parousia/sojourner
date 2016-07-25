package com.android.sojourner;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements DrawerAdapter.OnItemSelectListener {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabPagerAdapter mPagerAdapter;

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView mDrawerRecyclerView;
    private DrawerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up toolbar
        mToolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(mToolbar);

        // Initialize drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_activity_drawer);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.app_name,
                R.string.app_name
        ) {
            // When the drawer is completely closed
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            // Called when drawer is closed
            @Override
            public void onDrawerOpened(View drawerView) {

            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        // Set up RecyclerView and DrawerAdapter
        mDrawerRecyclerView = (RecyclerView) findViewById(R.id.main_activity_drawer_recyclerView);
        mDrawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DrawerAdapter();
        mAdapter.setOnItemClickListener(this);
        mDrawerRecyclerView.setAdapter(mAdapter);

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

    @Override
    public void onDrawerItemSelected(View v, int position) {
        switch (position) {
            // Header selected
            case 0:
                break;
            // All Treks Selected
            case 1:
                // Open up All Treks Activity
                Intent i = new Intent(MainActivity.this, AllTreksActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    /*****
     * Private Helper Methods
     *****/
    private void onNavDrawerItemSelected() {

    }

}
