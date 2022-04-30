package com.example.fragmentapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewpagerAdapter extends FragmentPagerAdapter {


    public ViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new ListFragment();

            case 1:
                return new ListFragment();

            default:
                return null;

        }
    }



    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position) {


           case 0:
               return "Calls";

           case 1:
               return "status";
           case 2:
               return "Chats";

           default:
               return null;


       }
    }
}
