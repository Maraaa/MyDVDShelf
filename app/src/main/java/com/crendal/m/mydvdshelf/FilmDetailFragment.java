package com.crendal.m.mydvdshelf;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crendal.m.mydvdshelf.Entities.DVD;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mara on 02/04/2015.
 */
public class FilmDetailFragment extends Fragment {

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

    private View view;

    public static FilmDetailFragment newInstance(DVD dvd)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_DVD, dvd);

        FilmDetailFragment fragment = new FilmDetailFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_film,container,false);
        ButterKnife.inject(this,rootView);
        view = rootView;
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();

        if (args != null) {
            DVD dvd = (DVD) args.getSerializable(KEY_DVD);
            displayFilmInfos(dvd);
        }
    }

    private void displayFilmInfos(DVD film){
        myTitleTextView.setText(film.getTitle());
        myGenreTextView.setText(film.getGenre());
        mySynopsysTextView.setText(film.getSynopsys());
        myProdTextView.setText(film.getProducteur());
        myDateTextView.setText(film.getDate());
        Picasso.with(view.getContext()).load(film.getImage_Path()).into(myImageView);
    }
}
