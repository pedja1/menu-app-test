package com.demo.menuapp.data.model.requestresponse.login;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.TestOnly;

public class LoginResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private String status;

	public int getCode(){
		return code;
	}

	public Data getData(){
		return data;
	}

	public String getStatus(){
		return status;
	}

	@TestOnly
	public void setData(Data data) {
		this.data = data;
	}
}