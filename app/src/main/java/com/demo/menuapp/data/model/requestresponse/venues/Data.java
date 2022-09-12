package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("venues")
	private List<VenuesItem> venues;

	public List<VenuesItem> getVenues(){
		return venues;
	}
}