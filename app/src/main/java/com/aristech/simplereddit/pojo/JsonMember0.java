package com.aristech.simplereddit.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class JsonMember0{

	@SerializedName("awardings_required")
	private int awardingsRequired;

	@SerializedName("resized_static_icons")
	private List<ResizedStaticIconsItem> resizedStaticIcons;

	@SerializedName("icon")
	private Icon icon;

	@SerializedName("static_icon")
	private StaticIcon staticIcon;

	@SerializedName("resized_icons")
	private List<ResizedIconsItem> resizedIcons;

	public int getAwardingsRequired(){
		return awardingsRequired;
	}

	public List<ResizedStaticIconsItem> getResizedStaticIcons(){
		return resizedStaticIcons;
	}

	public Icon getIcon(){
		return icon;
	}

	public StaticIcon getStaticIcon(){
		return staticIcon;
	}

	public List<ResizedIconsItem> getResizedIcons(){
		return resizedIcons;
	}
}