package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class DeliveryIntegrationProperties{

	@SerializedName("restaurant_id")
	private String restaurantId;

	public String getRestaurantId(){
		return restaurantId;
	}
}