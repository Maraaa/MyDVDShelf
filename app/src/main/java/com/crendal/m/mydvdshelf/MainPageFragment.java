package com.crendal.m.mydvdshelf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crendal.m.mydvdshelf.views.SlidingTabLayout;

/**
 * Created by Mara on 20/03/2015.
 */
public class MainPageFragment extends Fragment {

    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    private SlidingTabLayout slidingTabLayout;

    public MainPageFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.viewPager = (ViewPager) view.findViewById(R.id.myviewPager);
        this.slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.home_sliding_tabs);

        adapter = new FragmentPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        slidingTabLayout.setViewPager(viewPager);

        return view;
    }
}