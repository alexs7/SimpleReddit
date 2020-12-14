package com.aristech.simplereddit.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Preview{

  @SerializedName("images")
  private List<ImagesItem> images;

  @SerializedName("enabled")
  private boolean enabled;

  public List<ImagesItem> getImages(){
	return images;
  }

  public boolean isEnabled(){
	return enabled;
  }
}