package com.demo.menuapp.data.model.requestresponse.login;

import com.google.gson.annotations.SerializedName;

public class InfoMessage{

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}
}