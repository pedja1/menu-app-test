package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PriceConfiguration{

	@SerializedName("order_types")
	private List<OrderTypesItem> orderTypes;

	@SerializedName("external_channels")
	private List<Object> externalChannels;

	public List<OrderTypesItem> getOrderTypes(){
		return orderTypes;
	}

	public List<Object> getExternalChannels(){
		return externalChannels;
	}
}