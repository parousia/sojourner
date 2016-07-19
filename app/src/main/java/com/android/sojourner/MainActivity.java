package com.android.sojourner;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabPagerAdapter mPagerAdapter;

    private Toolbar mToolbar;
    private String[] mDrawerTitles;
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

        // Set up RecyclerView for Navigation drawer
        mDrawerRecyclerView = (RecyclerView) findViewById(R.id.main_activity_drawer_recyclerView);
        mDrawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // TODO: finish setting up adapter

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

    private class DrawerAdapter extends RecyclerView.Adapter<DrawerViewHolder>{
        ArrayList<DrawerItem> mItemList;

        public DrawerAdapter(ArrayList<DrawerItem> itemList) {
            mItemList = itemList;
        }

        @Override
        public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_drawer, parent, false);
            DrawerViewHolder holder = new DrawerViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(DrawerViewHolder holder, int position) {
            DrawerItem drawerItem = mItemList.get(position);
            holder.mItemName.setText(drawerItem.getmTitle());
            holder.mIconImage.setImageResource(drawerItem.getmIcon());
        }

        @Override
        public int getItemCount() {
            return mItemList.size();
        }
    }

    private class DrawerViewHolder extends RecyclerView.ViewHolder {
        TextView mItemName;
        ImageView mIconImage;

        public DrawerViewHolder(View itemView) {
            super(itemView);
            mItemName = (TextView)itemView.findViewById(R.id.title);
            mIconImage = (ImageView) itemView.findViewById(R.id.icon);
        }
    }
}
