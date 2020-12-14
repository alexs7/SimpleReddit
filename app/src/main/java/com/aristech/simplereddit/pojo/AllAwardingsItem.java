package com.aristech.simplereddit.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AllAwardingsItem{

  @SerializedName("icon_url")
  private String iconUrl;

  @SerializedName("icon_width")
  private int iconWidth;

  @SerializedName("end_date")
  private Object endDate;

  @SerializedName("award_sub_type")
  private String awardSubType;

  @SerializedName("is_new")
  private boolean isNew;

  @SerializedName("days_of_drip_extension")
  private int daysOfDripExtension;

  @SerializedName("coin_reward")
  private int coinReward;

  @SerializedName("icon_height")
  private int iconHeight;

  @SerializedName("count")
  private int count;

  @SerializedName("description")
  private String description;

  @SerializedName("resized_icons")
  private List<ResizedIconsItem> resizedIcons;

  @SerializedName("coin_price")
  private int coinPrice;

  @SerializedName("subreddit_coin_reward")
  private int subredditCoinReward;

  @SerializedName("icon_format")
  private Object iconFormat;

  @SerializedName("award_type")
  private String awardType;

  @SerializedName("subreddit_id")
  private Object subredditId;

  @SerializedName("giver_coin_reward")
  private Object giverCoinReward;

  @SerializedName("is_enabled")
  private boolean isEnabled;

  @SerializedName("penny_price")
  private Object pennyPrice;

  @SerializedName("penny_donate")
  private Object pennyDonate;

  @SerializedName("name")
  private String name;

  @SerializedName("id")
  private String id;

  @SerializedName("days_of_premium")
  private int daysOfPremium;

  @SerializedName("start_date")
  private Object startDate;

  public String getIconUrl(){
	return iconUrl;
  }

  public int getIconWidth(){
	return iconWidth;
  }

  public Object getEndDate(){
	return endDate;
  }

  public String getAwardSubType(){
	return awardSubType;
  }

  public boolean isIsNew(){
	return isNew;
  }

  public int getDaysOfDripExtension(){
	return daysOfDripExtension;
  }

  public int getCoinReward(){
	return coinReward;
  }

  public int getIconHeight(){
	return iconHeight;
  }

  public int getCount(){
	return count;
  }

  public String getDescription(){
	return description;
  }

  public List<ResizedIconsItem> getResizedIcons(){
	return resizedIcons;
  }

  public int getCoinPrice(){
	return coinPrice;
  }

  public int getSubredditCoinReward(){
	return subredditCoinReward;
  }

  public Object getIconFormat(){
	return iconFormat;
  }

  public String getAwardType(){
	return awardType;
  }

  public Object getSubredditId(){
	return subredditId;
  }

  public Object getGiverCoinReward(){
	return giverCoinReward;
  }

  public boolean isIsEnabled(){
	return isEnabled;
  }

  public Object getPennyPrice(){
	return pennyPrice;
  }

  public Object getPennyDonate(){
	return pennyDonate;
  }

  public String getName(){
	return name;
  }

  public String getId(){
	return id;
  }

  public int getDaysOfPremium(){
	return daysOfPremium;
  }

  public Object getStartDate(){
	return startDate;
  }
}