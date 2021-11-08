package com.rezwan2525.edutechmate.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.rezwan2525.edutechmate.fragments.CProgramFragment;
import com.rezwan2525.edutechmate.fragments.HTMLFragment;

public class ToolsPagerAdapter extends FragmentStatePagerAdapter {
    private static String TAG= "TAG_AuthPagerAdapter";
    private int numOfTabs;

    public ToolsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        numOfTabs = behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return CProgramFragment.newInstance();
            case 1:
                return HTMLFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

