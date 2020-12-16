package com.aristech.simplereddit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class SplashScreen extends AppCompatActivity {

  private static final String USERNAME = "xRr9te3xZbvHLg";
  private static final String PASSWORD = "";
  private static final String CLIENT_ID = USERNAME + ":" + PASSWORD;
  private static final String AUTHURL = "https://www.reddit.com/api/v1/access_token";
  private static final String TAG = "OAuthCall";
  private String accessToken = null;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	setContentView(R.layout.splash_screen);

	long time = 1000;

	new Handler().postDelayed(new Runnable() {
	  @Override
	  public void run() {

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

			  Intent intent = new Intent(SplashScreen.this, MainActivity.class);
			  intent.putExtra("accessToken", accessToken);
			  startActivity(intent);
			  finish();

			} catch (JSONException e) {
			  e.printStackTrace();
			}
		  }
		});

	  }
	}, time);

  }
}
