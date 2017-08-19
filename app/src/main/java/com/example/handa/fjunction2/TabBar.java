package com.example.handa.fjunction2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by handa on 11-Jun-17.
 */
public class TabBar extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public TabBar(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Home home = new Home();
                return home;
            case 1:
                 Search search = new Search();
                return search;
            case 2:
                Setting setting = new Setting();
                return setting;


            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }


}
