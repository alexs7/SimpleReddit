package com.aristech.simplereddit;

import com.aristech.simplereddit.pojo.ChildrenItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

  @Headers("cache-control: no-cache")
  @GET("r/all/top")
  Call<ChildrenItem> getTopPosts(
		  @Header("Authorization") String bearer_string, //https://www.youtube.com/watch?v=dh86zr4C2zg&feature=emb_logo (to use for all requests)
		  @Query("limit") int limit,
		  @Query("after") String after
  );
}
