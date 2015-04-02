package com.crendal.m.mydvdshelf;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.crendal.m.mydvdshelf.Entities.DVD;
import com.crendal.m.mydvdshelf.views.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends ActionBarActivity {

    @InjectView(R.id.myviewPager)
    ViewPager viewPager;

    /*@InjectView(R.id.toolbar)
    Toolbar mToolbar;*/

    @InjectView(R.id.home_sliding_tabs)
    SlidingTabLayout slidingTabLayout;

    private FragmentPagerAdapter adapter;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);

        buildFragmentsList();

        //setSupportActionBar(mToolbar);
        adapter = new FragmentPagerAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(adapter);
        slidingTabLayout.setViewPager(viewPager);

    }

    private void buildFragmentsList()
    {
        mFragments = new ArrayList<>();
        mFragments.add(new ListDVDFragment());
        mFragments.add(new AddFilmFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
       }


}
/*

        try {
            DBManager dbm = new DBManager(this);
            dbm.open();
            dbm.insert(myDVDtest);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/