package com.aristech.simplereddit;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.aristech.simplereddit.pojo.ChildrenItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<String, ChildrenItem> {

  public static final int PAGE_SIZE = 5;
  private static final int FIRST_PAGE = 1;
  private static final String SITE_NAME = "reddit";
  private String auth;

  public ItemDataSource(String auth) {
	this.auth = auth;
  }

  //  TODO: fill in these methods from here: https://www.youtube.com/watch?v=122mhJTCnx0
  @Override
  public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull final LoadInitialCallback<String, ChildrenItem> callback) {

	RetrofitClient.getInstance()
			.getApi()
			.getTopPosts(auth, PAGE_SIZE, null)
			.enqueue(new Callback<ChildrenItem>() {
			  @Override
			  public void onResponse(Call<ChildrenItem> call, Response<ChildrenItem> response) {

				if(response.body() != null){
				  callback.onResult(response.body().getData().getChildren(), null, response.body().getData().getAfter() );
				}

			  }

			  @Override
			  public void onFailure(Call<ChildrenItem> call, Throwable t) {

			  }
			});
  }

  @Override
  public void loadBefore(@NonNull LoadParams<String> params, @NonNull final LoadCallback<String, ChildrenItem> callback) {

	RetrofitClient.getInstance()
			.getApi()
			.getTopPosts(auth, PAGE_SIZE, null)
			.enqueue(new Callback<ChildrenItem>() {
			  @Override
			  public void onResponse(Call<ChildrenItem> call, Response<ChildrenItem> response) {

				if(response.body() != null){
				  callback.onResult(response.body().getData().getChildren(), null);
				}

			  }

			  @Override
			  public void onFailure(Call<ChildrenItem> call, Throwable t) {

			  }
			});
  }

  @Override
  public void loadAfter(@NonNull final LoadParams<String> params, @NonNull final LoadCallback<String, ChildrenItem> callback) {

	RetrofitClient.getInstance()
			.getApi()
			.getTopPosts(auth, PAGE_SIZE, params.key)
			.enqueue(new Callback<ChildrenItem>() {
			  @Override
			  public void onResponse(Call<ChildrenItem> call, Response<ChildrenItem> response) {

				if(response.body() != null){
				  LoadParams<String> paramsfoo = params;
				  String key = response.body().getData().getAfter();
				  callback.onResult(response.body().getData().getChildren(), key);
				}

			  }

			  @Override
			  public void onFailure(Call<ChildrenItem> call, Throwable t) {

			  }
			});
  }
}
