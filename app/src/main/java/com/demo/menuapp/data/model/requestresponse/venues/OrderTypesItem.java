package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class OrderTypesItem{

	@SerializedName("type_id")
	private int typeId;

	@SerializedName("external_channel_only")
	private boolean externalChannelOnly;

	@SerializedName("is_table_supported")
	private Object isTableSupported;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("reference_type")
	private String referenceType;

	@SerializedName("price_configuration")
	private int priceConfiguration;

	public int getTypeId(){
		return typeId;
	}

	public boolean isExternalChannelOnly(){
		return externalChannelOnly;
	}

	public Object getIsTableSupported(){
		return isTableSupported;
	}

	public int getId(){
		return id;
	}

	public int getState(){
		return state;
	}

	public String getReferenceType(){
		return referenceType;
	}

	public int getPriceConfiguration(){
		return priceConfiguration;
	}
}