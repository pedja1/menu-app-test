package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Country{

	@SerializedName("code_alpha3")
	private String codeAlpha3;

	@SerializedName("calling_code")
	private String callingCode;

	@SerializedName("is_address_number_first")
	private boolean isAddressNumberFirst;

	@SerializedName("code")
	private String code;

	@SerializedName("available_payment_methods")
	private List<AvailablePaymentMethodsItem> availablePaymentMethods;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("code_numeric")
	private String codeNumeric;

	@SerializedName("currency_settings")
	private CurrencySettings currencySettings;

	@SerializedName("distance_unit")
	private String distanceUnit;

	@SerializedName("currency_id")
	private int currencyId;

	@SerializedName("supported_travel_modes")
	private List<Object> supportedTravelModes;

	public String getCodeAlpha3(){
		return codeAlpha3;
	}

	public String getCallingCode(){
		return callingCode;
	}

	public boolean isIsAddressNumberFirst(){
		return isAddressNumberFirst;
	}

	public String getCode(){
		return code;
	}

	public List<AvailablePaymentMethodsItem> getAvailablePaymentMethods(){
		return availablePaymentMethods;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getCodeNumeric(){
		return codeNumeric;
	}

	public CurrencySettings getCurrencySettings(){
		return currencySettings;
	}

	public String getDistanceUnit(){
		return distanceUnit;
	}

	public int getCurrencyId(){
		return currencyId;
	}

	public List<Object> getSupportedTravelModes(){
		return supportedTravelModes;
	}
}