package com.tv.movieapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Myapi
{
    @GET("posts")
    Call<List<Data_Model>>getmodel();
}
