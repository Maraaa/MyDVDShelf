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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_film);
        ButterKnife.inject(this);

        DVD dvd = (DVD) getIntent().getSerializableExtra("dvd");

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putSerializable("dvd", dvd);
            FilmDetailFragment fragment = new FilmDetailFragment();
            fragment.setArguments(arguments);
            //getSupportFragmentManager().beginTransaction().add(R.id.film_detail_container, fragment).commit();
        }
    }


}
