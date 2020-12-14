package com.aristech.simplereddit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.aristech.simplereddit.pojo.ChildrenItem;

public class ItemViewModel extends ViewModel {

  public LiveData<PagedList<ChildrenItem>> itemPagedList;
  public LiveData<PageKeyedDataSource<String, ChildrenItem>> liveDataSource;

  public ItemViewModel(){
    // TODO: READ HERE
	ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory(" Bearer FIND A WAY TO PASS THIS DYNAMICALLY");
	liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

	PagedList.Config config = (new PagedList.Config.Builder())
			.setEnablePlaceholders(false)
			.setPageSize(ItemDataSource.PAGE_SIZE)
			.build();

	itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();
  }
}
