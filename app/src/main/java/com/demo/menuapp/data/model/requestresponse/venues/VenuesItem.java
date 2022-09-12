package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class VenuesItem{

	@SerializedName("distance_in_miles")
	private double distanceInMiles;

	@SerializedName("venue")
	private Venue venue;

	@SerializedName("distance")
	private double distance;

	public double getDistanceInMiles(){
		return distanceInMiles;
	}

	public Venue getVenue(){
		return venue;
	}

	public double getDistance(){
		return distance;
	}
}