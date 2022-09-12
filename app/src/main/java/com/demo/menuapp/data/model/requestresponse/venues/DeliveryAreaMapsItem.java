package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DeliveryAreaMapsItem{

	@SerializedName("minimal_order_amount")
	private Object minimalOrderAmount;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("area_id")
	private int areaId;

	@SerializedName("radius")
	private Object radius;

	@SerializedName("delivery_fee_id")
	private int deliveryFeeId;

	public Object getMinimalOrderAmount(){
		return minimalOrderAmount;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getName(){
		return name;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public int getState(){
		return state;
	}

	public int getAreaId(){
		return areaId;
	}

	public Object getRadius(){
		return radius;
	}

	public int getDeliveryFeeId(){
		return deliveryFeeId;
	}
}