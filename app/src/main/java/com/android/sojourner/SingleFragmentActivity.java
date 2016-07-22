package com.android.sojourner;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jlian on 6/9/2016.
 */
//abstract class for any general activity that hosts exactly one fragment(e.g. CrimeActivity hosting CrimeFragment)
public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    //to inflate and not hardcode the layout
    @LayoutRes
    protected int getLayoutResId(){
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = createFragment();
            //beginTransaction method creates instance of FragmentTransaction
            //add method and after represents creating and committing a fragment transaction
            //fragment transaction: used to add,remove, attach, or replace fragments in fragment list
            //create new fragment transaction, include an add operation, and commit it
            //R.id.fragment_container is a container view ID for (1)telling fragment manager
            //where in activity's view the fragment's view should appear & (2)unique id for fragment
            //in fragment manager's list (retrieve CrimeFragment from FragmentManager by container view id)
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
