package com.crendal.m.mydvdshelf.API;

import com.crendal.m.mydvdshelf.Entities.DVD;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Mara on 19/03/2015.
 */
public interface API_interface {


    @GET("/imdb")
    public void fetchMovieInfo(@Query("title") String filmTitle, @Query("format") String returnFormat, Callback<DVD> callback);

}
