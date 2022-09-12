package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class ExternalChannelsItem{

	@SerializedName("type_id")
	private int typeId;

	@SerializedName("price_configuration")
	private int priceConfiguration;

	public int getTypeId(){
		return typeId;
	}

	public int getPriceConfiguration(){
		return priceConfiguration;
	}
}