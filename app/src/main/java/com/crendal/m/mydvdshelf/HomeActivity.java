package com.crendal.m.mydvdshelf;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.crendal.m.mydvdshelf.API.API_Constants;
import com.crendal.m.mydvdshelf.API.API_myApiFilms;
import com.crendal.m.mydvdshelf.DB.DBManager;
import com.crendal.m.mydvdshelf.Entities.DVD;

import org.apache.http.HttpResponse;

import java.sql.SQLException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.RestAdapter;


public class HomeActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        ButterKnife.inject(this);

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
/*DVD myDVDtest = new DVD();

        myDVDtest.setTitle("Matrix");
        myDVDtest.setDate("31/03/1999");
        myDVDtest.setGenre("Action");
        myDVDtest.setProducteur("Wakowski");
        myDVDtest.setSynopsys("Thomas A. Anderson is a man living two lives. By day he is an average computer programmer and by night a hacker known as Neo. Neo has always questioned his reality, but the truth is far beyond his imagination. Neo finds himself targeted by the police when he is contacted by Morpheus, a legendary computer hacker branded a terrorist by the government. Morpheus awakens Neo to the real world, a ravaged wasteland where most of humanity have been captured by a race of machines that live off of the humans\' body heat and electrochemical energy and who imprison their minds within an artificial reality known as the Matrix. As a rebel against the machines, Neo must return to the Matrix and confront the agents: super-powerful computer programs devoted to snuffing out Neo and the entire human rebellion.");
        myDVDtest.setImage_Path("https://lh4.ggpht.com/kz9G0SEEsJBaH3RLn5dzg2CvkZtk8miF4pbiPb4sCUQpsHuRq5GpqyTGTsJU8YTojRU=w300");

        try {
            DBManager dbm = new DBManager(this);
            dbm.open();
            dbm.insert(myDVDtest);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/