package com.crendal.m.mydvdshelf;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.crendal.m.mydvdshelf.Entities.DVD;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mara on 02/04/2015.
 */
public class FSImageActivity extends BaseActivity {

    @InjectView(R.id.fs_imageView)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_image_fs);
        ButterKnife.inject(this);

        DVD dvd = (DVD) getIntent().getSerializableExtra("dvd");

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putSerializable("dvd", dvd);
            displayImage(dvd.getImage_Path());
        }

    }

    private void displayImage(String url)
    {
        Picasso.with(this).load(url).into(mImageView);
    }

}
