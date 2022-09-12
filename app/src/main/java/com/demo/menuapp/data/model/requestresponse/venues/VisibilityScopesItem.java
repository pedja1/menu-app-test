package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class VisibilityScopesItem{

	@SerializedName("scope_id")
	private int scopeId;

	@SerializedName("scope_type")
	private String scopeType;

	public int getScopeId(){
		return scopeId;
	}

	public String getScopeType(){
		return scopeType;
	}
}