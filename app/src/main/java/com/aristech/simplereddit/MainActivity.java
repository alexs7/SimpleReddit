package com.aristech.simplereddit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.WindowManager;
import com.aristech.simplereddit.pojo.ChildrenItem;


public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView = null;
  private Intent intent = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	setContentView(R.layout.activity_main);
	getSupportActionBar().setTitle("r/all/top");
	intent = getIntent();
  }

  @Override
  protected void onResume() {
	super.onResume();

	final String accessToken = intent.getStringExtra("accessToken");

	// UI Code
	recyclerView = findViewById(R.id.recyclerView);
	recyclerView.setLayoutManager(new LinearLayoutManager(this));
	recyclerView.setHasFixedSize(true);

	ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
	  @NonNull
	  @Override
	  public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
		return (T) new ItemViewModel(accessToken);
	  }
	};

	ItemViewModel itemViewModel = new ViewModelProvider(this, factory).get(ItemViewModel.class);
	final RedditItemAdapter redditItemAdapter = new RedditItemAdapter(this);

	itemViewModel.itemPagedList.observe(this, new Observer<PagedList<ChildrenItem>>() {
	  @Override
	  public void onChanged(@Nullable PagedList<ChildrenItem> childrenItems) {
		redditItemAdapter.submitList(childrenItems);
	  }
	});

	recyclerView.setAdapter(redditItemAdapter);
  }

}