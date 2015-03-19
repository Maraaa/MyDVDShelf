package com.crendal.m.mydvdshelf.API;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.squareup.okhttp.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

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
                .build();
        return restAdapter;
    }

    public String getMovieInfos(String movieTitle){
        //String query = base_url + param_film_title + movieTitle + format_json;

        RestAdapter ra = this.connection();

        API_interface myApi = ra.create(API_interface.class);

        String retour = myApi.fetchMovieInfo(movieTitle);

        return retour;
    }//change return type

}
