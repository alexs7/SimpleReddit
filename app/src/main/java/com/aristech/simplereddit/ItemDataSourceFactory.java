package com.aristech.simplereddit;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.aristech.simplereddit.pojo.ChildrenItem;

public class ItemDataSourceFactory extends DataSource.Factory {

  private String auth;
  private MutableLiveData<PageKeyedDataSource<String, ChildrenItem>> itemLiveDataSource = new MutableLiveData<>();

  public ItemDataSourceFactory(String auth) {
	this.auth = auth;
  }

  @Override
  public DataSource create() {
	ItemDataSource itemDataSource = new ItemDataSource(auth);
	itemLiveDataSource.postValue(itemDataSource);
	return itemDataSource;
  }

  public MutableLiveData<PageKeyedDataSource<String, ChildrenItem>> getItemLiveDataSource() {
	return itemLiveDataSource;
  }
}
