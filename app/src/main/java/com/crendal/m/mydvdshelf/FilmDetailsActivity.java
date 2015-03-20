package com.crendal.m.mydvdshelf;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.crendal.m.mydvdshelf.DB.DBManager;
import com.crendal.m.mydvdshelf.Entities.DVD;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mara on 20/03/2015.
 */
public class FilmDetailsActivity extends BaseActivity{

    @InjectView(R.id.film_titleTextView)
    TextView myTitleTextView;

    @InjectView(R.id.film_dateTextView)
    TextView myDateTextView;

    @InjectView(R.id.film_genreTextView)
    TextView myGenreTextView;

    @InjectView(R.id.film_prodTextView)
    TextView myProdTextView;

    @InjectView(R.id.film_synopsysTextView)
    TextView mySynopsysTextView;

    @InjectView(R.id.film_imageView)
    ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_film);
        ButterKnife.inject(this);

        DVD myDVDtest = new DVD();

        myDVDtest.setTitle("Matrix");
        myDVDtest.setDate("31/03/1999");
        myDVDtest.setGenre("Action");
        myDVDtest.setProducteur("Wakowski");
        myDVDtest.setSynopsys("Thomas A. Anderson is a man living two lives. By day he is an average computer programmer and by night a hacker known as Neo. Neo has always questioned his reality, but the truth is far beyond his imagination. Neo finds himself targeted by the police when he is contacted by Morpheus, a legendary computer hacker branded a terrorist by the government. Morpheus awakens Neo to the real world, a ravaged wasteland where most of humanity have been captured by a race of machines that live off of the humans\' body heat and electrochemical energy and who imprison their minds within an artificial reality known as the Matrix. As a rebel against the machines, Neo must return to the Matrix and confront the agents: super-powerful computer programs devoted to snuffing out Neo and the entire human rebellion.");
        myDVDtest.setImage_Path("https://lh4.ggpht.com/kz9G0SEEsJBaH3RLn5dzg2CvkZtk8miF4pbiPb4sCUQpsHuRq5GpqyTGTsJU8YTojRU=w300");

        this.displayFilmInfos(myDVDtest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    private void displayFilmInfos(DVD film){
        myTitleTextView.setText(film.getTitle());
        myGenreTextView.setText(film.getGenre());
        mySynopsysTextView.setText(film.getSynopsys());
        myProdTextView.setText(film.getProducteur());
        myDateTextView.setText(film.getDate());
        Picasso.with(this).load(film.getImage_Path()).into(myImageView);
    }
}
