package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ServingTimesItem{

	@SerializedName("time_to")
	private String timeTo;

	@SerializedName("time_from")
	private String timeFrom;

	@SerializedName("type_id")
	private int typeId;

	@SerializedName("days")
	private List<Integer> days;

	@SerializedName("id")
	private int id;

	@SerializedName("reference_type")
	private String referenceType;

	@SerializedName("delivery_at")
	private Object deliveryAt;

	public String getTimeTo(){
		return timeTo;
	}

	public String getTimeFrom(){
		return timeFrom;
	}

	public int getTypeId(){
		return typeId;
	}

	public List<Integer> getDays(){
		return days;
	}

	public int getId(){
		return id;
	}

	public String getReferenceType(){
		return referenceType;
	}

	public Object getDeliveryAt(){
		return deliveryAt;
	}
}