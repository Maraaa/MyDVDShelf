package com.crendal.m.mydvdshelf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.crendal.m.mydvdshelf.Entities.DVD;
import com.crendal.m.mydvdshelf.views.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mara on 20/03/2015.
 */
public class ListDVDFragment extends Fragment {

    ArrayList<DVD> mList;
    private FilmListAdapter mAdapter;

    @InjectView(R.id.listView)
    ListView mListView;

    public ListDVDFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_film_list, container, false);

        ButterKnife.inject(this,view);

        mList = buildDVDList();
        mAdapter = new FilmListAdapter(getActivity(), mList);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),FilmDetailsActivity.class);
                Bundle bundle = new Bundle();
                i.putExtra("dvd",mList.get(position));
                startActivity(i);
            }
        });

        return view;
    }

    public ArrayList<DVD> buildDVDList()
    {
        ArrayList<DVD> list = new ArrayList<>();
        DVD myDVDtest = new DVD();

        myDVDtest.setTitle("Matrix");
        myDVDtest.setDate("31/03/1999");
        myDVDtest.setGenre("Action");
        myDVDtest.setProducteur("Wakowski");
        myDVDtest.setSynopsys("Thomas A. Anderson is a man living two lives. By day he is an average computer programmer and by night a hacker known as Neo. Neo has always questioned his reality, but the truth is far beyond his imagination. Neo finds himself targeted by the police when he is contacted by Morpheus, a legendary computer hacker branded a terrorist by the government. Morpheus awakens Neo to the real world, a ravaged wasteland where most of humanity have been captured by a race of machines that live off of the humans\' body heat and electrochemical energy and who imprison their minds within an artificial reality known as the Matrix. As a rebel against the machines, Neo must return to the Matrix and confront the agents: super-powerful computer programs devoted to snuffing out Neo and the entire human rebellion.");
        myDVDtest.setImage_Path("https://lh4.ggpht.com/kz9G0SEEsJBaH3RLn5dzg2CvkZtk8miF4pbiPb4sCUQpsHuRq5GpqyTGTsJU8YTojRU=w300");

        list.add(myDVDtest);

        DVD myDVDtest2 = new DVD();
        myDVDtest2.setTitle("Jumanji");
        myDVDtest2.setDate("15/12/1995");
        myDVDtest2.setGenre("Aventure");
        myDVDtest2.setProducteur("Jor Johnston");
        myDVDtest2.setSynopsys("After being trapped in a jungle board game for 26 years, a Man-Child wins his release from the game. But, no sooner has he arrived that he is forced to play again, and this time sets the creatures of the jungle loose on the city. Now it is up to him to stop them.");
        myDVDtest2.setImage_Path("http://ia.media-imdb.com/images/M/MV5BMTk5MjAyNTM4Ml5BMl5BanBnXkFtZTgwMjY0MDI0MjE@._V1_SX214_AL_.jpg");

        list.add(myDVDtest2);

        return list;
    }

}