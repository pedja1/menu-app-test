package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class CurrencySettings{

	@SerializedName("decimal_separator")
	private String decimalSeparator;

	@SerializedName("thousands_separator")
	private String thousandsSeparator;

	@SerializedName("symbol_position")
	private String symbolPosition;

	@SerializedName("currency_space")
	private boolean currencySpace;

	public String getDecimalSeparator(){
		return decimalSeparator;
	}

	public String getThousandsSeparator(){
		return thousandsSeparator;
	}

	public String getSymbolPosition(){
		return symbolPosition;
	}

	public boolean isCurrencySpace(){
		return currencySpace;
	}
}