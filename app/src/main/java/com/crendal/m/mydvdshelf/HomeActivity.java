package com.crendal.m.mydvdshelf;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.crendal.m.mydvdshelf.API.API_Constants;
import com.crendal.m.mydvdshelf.API.API_myApiFilms;

import org.apache.http.HttpResponse;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.RestAdapter;


public class HomeActivity extends ActionBarActivity {

    @InjectView(R.id.textView)
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
        API_myApiFilms api = new API_myApiFilms();
        myTextView.setText(api.getMovieInfos("Matrix"));
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
