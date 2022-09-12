package com.demo.menuapp.data.model.requestresponse.login;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.TestOnly;

public class Data{

	@SerializedName("customer_account")
	private CustomerAccount customerAccount;

	@SerializedName("token")
	private Token token;

	@SerializedName("message")
	private String message;

	@SerializedName("info_message")
	private InfoMessage infoMessage;

	public CustomerAccount getCustomerAccount(){
		return customerAccount;
	}

	public Token getToken(){
		return token;
	}

	public InfoMessage getInfoMessage() {
		return infoMessage;
	}

	@TestOnly
	public void setToken(Token token) {
		this.token = token;
	}
}