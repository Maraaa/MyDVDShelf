package com.crendal.m.mydvdshelf;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public static final String KEY_DVD = "dvd";

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

    DVD currentDVD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_film);
        ButterKnife.inject(this);

        DVD dvd = (DVD) getIntent().getSerializableExtra("dvd");

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putSerializable("dvd", dvd);
            currentDVD = dvd;
            displayFilmInfos(dvd);
        }

        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showImageFS();
            }
        });

    }

    private void showImageFS()
    {
        Intent i = new Intent(this,FSImageActivity.class);
        Bundle bundle = new Bundle();
        i.putExtra("dvd",currentDVD);
        startActivity(i);
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
