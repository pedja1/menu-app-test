package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AvailablePaymentMethodsItem{

	@SerializedName("payment_method_id")
	private int paymentMethodId;

	@SerializedName("payment_method_brand")
	private String paymentMethodBrand;

	@SerializedName("payment_method_type_id")
	private int paymentMethodTypeId;

	@SerializedName("payment_processor_id")
	private int paymentProcessorId;

	@SerializedName("id")
	private int id;

	@SerializedName("payment_processor_type_id")
	private int paymentProcessorTypeId;

	@SerializedName("properties")
	private Object properties;

	@SerializedName("fraud_detection_processor_id")
	private Object fraudDetectionProcessorId;

	@SerializedName("visibility_scopes")
	private Object visibilityScopes;

	public int getPaymentMethodId(){
		return paymentMethodId;
	}

	public String getPaymentMethodBrand(){
		return paymentMethodBrand;
	}

	public int getPaymentMethodTypeId(){
		return paymentMethodTypeId;
	}

	public int getPaymentProcessorId(){
		return paymentProcessorId;
	}

	public int getId(){
		return id;
	}

	public int getPaymentProcessorTypeId(){
		return paymentProcessorTypeId;
	}

	public Object getProperties(){
		return properties;
	}

	public Object getFraudDetectionProcessorId(){
		return fraudDetectionProcessorId;
	}

	public Object getVisibilityScopes(){
		return visibilityScopes;
	}
}