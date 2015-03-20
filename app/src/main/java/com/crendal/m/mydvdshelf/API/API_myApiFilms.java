package com.crendal.m.mydvdshelf.API;

import android.util.Log;

import com.crendal.m.mydvdshelf.Entities.DVD;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;

/**
 * Created by Mara on 13/03/2015.
 */
public class API_myApiFilms {

    //api url = http://www.myapifilms.com/imdb?title=matrix%20reloaded&format=xml

    public API_myApiFilms()
    {

    }

    private RestAdapter connection()
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_Constants.base_url)  //call your base url
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return restAdapter;
    }

    public String getMovieInfos(String movieTitle){
        //String query = base_url + param_film_title + movieTitle + format_json;

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_Constants.base_url)  //call your base url
                .build();

        API_interface myApi = restAdapter.create(API_interface.class);

        final String[] succes = {"NO_RESULT"};

        myApi.fetchMovieInfo(movieTitle, "json",new Callback<DVD>() {
            @Override
             public void success(DVD retour, retrofit.client.Response response) {
                 Log.i("App", retour.getTitle());
                 succes[0] = retour.getTitle();
             }

             @Override
             public void failure(RetrofitError error) {
                 Log.i("App", error.getMessage());
                 succes[0] = error.getMessage();
             }
         });

        return succes[0];
    }//change return type

}
