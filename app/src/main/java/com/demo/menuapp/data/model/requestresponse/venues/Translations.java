package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class Translations{

	@SerializedName("description")
	private Object description;

	@SerializedName("welcome_message")
	private Object welcomeMessage;

	@SerializedName("kiosk_receipt_footer")
	private Object kioskReceiptFooter;

	public Object getDescription(){
		return description;
	}

	public Object getWelcomeMessage(){
		return welcomeMessage;
	}

	public Object getKioskReceiptFooter(){
		return kioskReceiptFooter;
	}
}