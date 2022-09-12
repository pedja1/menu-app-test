package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class Timezone{

	@SerializedName("offset")
	private String offset;

	@SerializedName("name")
	private String name;

	public String getOffset(){
		return offset;
	}

	public String getName(){
		return name;
	}
}