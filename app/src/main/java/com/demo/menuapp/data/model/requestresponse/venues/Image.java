package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class Image{

	@SerializedName("thumbnail_small")
	private String thumbnailSmall;

	@SerializedName("thumbnail_medium")
	private String thumbnailMedium;

	@SerializedName("fullsize")
	private String fullsize;

	public String getThumbnailSmall(){
		return thumbnailSmall;
	}

	public String getThumbnailMedium(){
		return thumbnailMedium;
	}

	public String getFullsize(){
		return fullsize;
	}
}