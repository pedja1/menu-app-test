package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class Currency{

	@SerializedName("symbol")
	private String symbol;

	@SerializedName("code")
	private String code;

	@SerializedName("rounding_unit")
	private double roundingUnit;

	@SerializedName("rounding_unit_tip")
	private double roundingUnitTip;

	@SerializedName("id")
	private int id;

	@SerializedName("code_numeric")
	private String codeNumeric;

	public String getSymbol(){
		return symbol;
	}

	public String getCode(){
		return code;
	}

	public double getRoundingUnit(){
		return roundingUnit;
	}

	public double getRoundingUnitTip(){
		return roundingUnitTip;
	}

	public int getId(){
		return id;
	}

	public String getCodeNumeric(){
		return codeNumeric;
	}
}