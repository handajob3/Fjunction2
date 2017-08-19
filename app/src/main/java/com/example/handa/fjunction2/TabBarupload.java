package com.example.handa.fjunction2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by handa on 15-Jun-17.
 */
public class TabBarupload extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public TabBarupload(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Upload upload = new Upload();
                return upload;
            case 1:
                Uploadphoto uploadphoto = new Uploadphoto();
                return uploadphoto;
            case 2:
                Uploadvideo uploadvideo = new Uploadvideo();
                return uploadvideo;


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
