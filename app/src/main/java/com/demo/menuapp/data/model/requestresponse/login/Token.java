package com.demo.menuapp.data.model.requestresponse.login;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.TestOnly;

public class Token{

	@SerializedName("refresh_ttl")
	private int refreshTtl;

	@SerializedName("value")
	private String value;

	@SerializedName("ttl")
	private int ttl;

	public int getRefreshTtl(){
		return refreshTtl;
	}

	public String getValue(){
		return value;
	}

	public int getTtl(){
		return ttl;
	}

	@TestOnly
	public void setValue(String value) {
		this.value = value;
	}
}