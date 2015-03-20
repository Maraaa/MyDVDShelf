package com.crendal.m.mydvdshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.crendal.m.mydvdshelf.Entities.DVD;

import java.util.List;

/**
 * Created by Mara on 20/03/2015.
 */
public class FilmListAdapter extends BaseAdapter {

    private Context context;
    private List<DVD> dataSource;
    private FilmItemViewHolder viewHolder;
    private View cellView;
    private DVD myFilm;

    public FilmListAdapter(Context context, List<DVD> filmList) {
        this.context = context;
        this.dataSource = filmList;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        cellView = convertView;
        myFilm = dataSource.get(position);
        if(cellView == null)
        {
            
        }
    }
}
