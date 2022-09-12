package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class Properties{

	@SerializedName("pos_wait_until_paid")
	private boolean posWaitUntilPaid;

	@SerializedName("max_cash_amount")
	private int maxCashAmount;

	@SerializedName("location_type")
	private String locationType;

	public boolean isPosWaitUntilPaid(){
		return posWaitUntilPaid;
	}

	public int getMaxCashAmount(){
		return maxCashAmount;
	}

	public String getLocationType(){
		return locationType;
	}
}