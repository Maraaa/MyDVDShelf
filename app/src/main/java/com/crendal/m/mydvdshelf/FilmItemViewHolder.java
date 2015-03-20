package com.crendal.m.mydvdshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crendal.m.mydvdshelf.Entities.DVD;
import com.squareup.picasso.Picasso;

import butterknife.InjectView;

/**
 * Created by Mara on 20/03/2015.
 */
public class FilmItemViewHolder {

    private Context context;
    private View filmView;

    @InjectView(R.id.detail_textView)
    TextView myTextView;

    @InjectView(R.id.detail_imageView)
    ImageView myImageView;

    public FilmItemViewHolder(Context context) {
        this.context = context;
        createView();
    }

    private void createView() {
        filmView = LayoutInflater.from(context).inflate(R.layout.fragment_film_detail, null);
    }

    public void updateView(DVD film) {
        myTextView.setText(film.getTitle());
        Picasso.with(context).load(film.getImage_Path()).into(myImageView);
    }

    public View getView()
    {
        return filmView;
    }
}
