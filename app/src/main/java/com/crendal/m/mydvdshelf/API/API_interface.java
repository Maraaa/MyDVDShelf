package com.crendal.m.mydvdshelf.API;

import com.squareup.okhttp.Response;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Mara on 19/03/2015.
 */
public interface API_interface {


    @GET("/imdb?title=")
    public String fetchMovieInfo(@Query("title") String title);

}
