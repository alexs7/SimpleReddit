package com.aristech.simplereddit.pojo;

import com.google.gson.annotations.SerializedName;

public class StaticIcon{

	@SerializedName("width")
	private int width;

	@SerializedName("format")
	private Object format;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	public int getWidth(){
		return width;
	}

	public Object getFormat(){
		return format;
	}

	public String getUrl(){
		return url;
	}

	public int getHeight(){
		return height;
	}
}