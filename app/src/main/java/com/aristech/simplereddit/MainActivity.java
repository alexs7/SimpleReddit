package com.aristech.simplereddit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.aristech.simplereddit.pojo.ChildrenItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView = null;
  private String accessToken = null;
  private static final String USERNAME = "xRr9te3xZbvHLg";
  private static final String PASSWORD = "";
  private static final String CLIENT_ID = USERNAME + ":" + PASSWORD;
  private static final String AUTHURL = "https://www.reddit.com/api/v1/access_token";
  private static final String TAG = "OAuthCall";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
  }

  @Override
  protected void onResume() {
	super.onResume();

	recyclerView = findViewById(R.id.recyclerView);
	recyclerView.setLayoutManager(new LinearLayoutManager(this));
	recyclerView.setHasFixedSize(true);

	ItemViewModel itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
	final RedditItemAdapter redditItemAdapter = new RedditItemAdapter(this);

	itemViewModel.itemPagedList.observe(this, new Observer<PagedList<ChildrenItem>>() {
	  @Override
	  public void onChanged(@Nullable PagedList<ChildrenItem> childrenItems) {
		redditItemAdapter.submitList(childrenItems);
	  }
	});

	recyclerView.setAdapter(redditItemAdapter);

	final OkHttpClient client = new OkHttpClient();
	String encodedAuthString = Base64.encodeToString(CLIENT_ID.getBytes(), Base64.NO_WRAP);

	MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
	RequestBody body = RequestBody.create(mediaType, "grant_type=https%3A%2F%2Foauth.reddit.com%2Fgrants%2Finstalled_client&device_id=DO_NOT_TRACK_THIS_DEVICE&undefined=");
	Request request = new Request.Builder()
			.url(AUTHURL)
			.post(body)
			.addHeader("Content-Type", "application/x-www-form-urlencoded")
			.addHeader("Authorization", "Basic " + encodedAuthString) //base64 of app id
			.addHeader("cache-control", "no-cache")
			.build();

	client.newCall(request).enqueue(new Callback() {
	  @Override
	  public void onFailure(Call call, IOException e) {
		Log.e(TAG, "ERROR: " + e);
	  }

	  @Override
	  public void onResponse(Call call, Response response) throws IOException {
		String json = response.body().string();

		JSONObject data = null;
		try {
		  data = new JSONObject(json);
		  accessToken = data.optString("access_token");
		  Log.d(TAG, "Access Token = " + accessToken);



		} catch (JSONException e) {
		  e.printStackTrace();
		}
	  }
	});
  }

}