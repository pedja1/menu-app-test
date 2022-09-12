package com.demo.menuapp.data.model.requestresponse.login;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CustomerAccount{

	@SerializedName("type_id")
	private int typeId;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("locale")
	private String locale;

	@SerializedName("optin_status_pn")
	private int optinStatusPn;

	@SerializedName("confirmed")
	private boolean confirmed;

	@SerializedName("reference_type")
	private String referenceType;

	@SerializedName("brand_id")
	private int brandId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("optin_status_email")
	private int optinStatusEmail;

	@SerializedName("phone_number")
	private String phoneNumber;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("customer_id")
	private int customerId;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	@SerializedName("demographics")
	private List<Object> demographics;

	public int getTypeId(){
		return typeId;
	}

	public String getLastName(){
		return lastName;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getLocale(){
		return locale;
	}

	public int getOptinStatusPn(){
		return optinStatusPn;
	}

	public boolean isConfirmed(){
		return confirmed;
	}

	public String getReferenceType(){
		return referenceType;
	}

	public int getBrandId(){
		return brandId;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getOptinStatusEmail(){
		return optinStatusEmail;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public int getId(){
		return id;
	}

	public int getState(){
		return state;
	}

	public int getCustomerId(){
		return customerId;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getEmail(){
		return email;
	}

	public List<Object> getDemographics(){
		return demographics;
	}
}