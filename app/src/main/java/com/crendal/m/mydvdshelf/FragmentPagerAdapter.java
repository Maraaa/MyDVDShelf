package com.crendal.m.mydvdshelf;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mara on 20/03/2015.
 */
public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter{

    private List<Fragment> dataSource;

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        dataSource = new ArrayList<Fragment>();
        /*dataSource.add(new HelloPageFragment());
        dataSource.add(new ListPersonPageFragment());*/
    }

    @Override
    public Fragment getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    public CharSequence getPageTitle(int position) {
        CharSequence title = "";
        if(position == 0) { title = "Accueil"; }
        else if(position == 1) { title = "Liste des contacts"; }
        else { title = "..."; }
        return title;
    }

}

