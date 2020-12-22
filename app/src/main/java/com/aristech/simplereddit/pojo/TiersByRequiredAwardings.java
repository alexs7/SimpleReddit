package com.aristech.simplereddit.pojo;

import com.google.gson.annotations.SerializedName;

public class TiersByRequiredAwardings{

	@SerializedName("0")
	private JsonMember0 jsonMember0;

	@SerializedName("2")
	private JsonMember2 jsonMember2;

	@SerializedName("4")
	private JsonMember4 jsonMember4;

	public JsonMember0 getJsonMember0(){
		return jsonMember0;
	}

	public JsonMember2 getJsonMember2(){
		return jsonMember2;
	}

	public JsonMember4 getJsonMember4(){
		return jsonMember4;
	}
}