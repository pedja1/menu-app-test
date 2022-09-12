package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Venue{

	@SerializedName("country")
	private Country country;

	@SerializedName("is_smart_orders_enabled")
	private boolean isSmartOrdersEnabled;

	@SerializedName("used_price_configurations")
	private List<Integer> usedPriceConfigurations;

	@SerializedName("areas")
	private List<AreasItem> areas;

	@SerializedName("language_id")
	private int languageId;

	@SerializedName("will_open")
	private boolean willOpen;

	@SerializedName("store_group_id")
	private Object storeGroupId;

	@SerializedName("calculation_method")
	private String calculationMethod;

	@SerializedName("translations")
	private Translations translations;

	@SerializedName("tip_max")
	private int tipMax;

	@SerializedName("is_shown_in_directory")
	private boolean isShownInDirectory;

	@SerializedName("delivery_integration_properties")
	private Object deliveryIntegrationProperties;

	@SerializedName("is_threeds_enabled")
	private boolean isThreedsEnabled;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("serving_times")
	private List<Object> servingTimes;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("zip")
	private String zip;

	@SerializedName("has_discounts")
	private boolean hasDiscounts;

	@SerializedName("image")
	private Image image;

	@SerializedName("allow_item_comments")
	private boolean allowItemComments;

	@SerializedName("is_open")
	private boolean isOpen;

	@SerializedName("price_configuration")
	private PriceConfiguration priceConfiguration;

	@SerializedName("parent_type")
	private String parentType;

	@SerializedName("brand_id")
	private int brandId;

	@SerializedName("phone")
	private String phone;

	@SerializedName("parent_id")
	private int parentId;

	@SerializedName("default_delivery_buffer")
	private int defaultDeliveryBuffer;

	@SerializedName("name")
	private String name;

	@SerializedName("integration")
	private Integration integration;

	@SerializedName("pickup_time")
	private int pickupTime;

	@SerializedName("country_id")
	private int countryId;

	@SerializedName("code")
	private String code;

	@SerializedName("chain_id")
	private Object chainId;

	@SerializedName("city")
	private String city;

	@SerializedName("timezone")
	private Timezone timezone;

	@SerializedName("imprint")
	private String imprint;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("delivery_travel_type")
	private String deliveryTravelType;

	@SerializedName("description")
	private String description;

	@SerializedName("tip_default")
	private int tipDefault;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("has_loyalty")
	private boolean hasLoyalty;

	@SerializedName("welcome_message")
	private String welcomeMessage;

	@SerializedName("has_delivery_integration")
	private boolean hasDeliveryIntegration;

	@SerializedName("store_url")
	private String storeUrl;

	@SerializedName("is_pickup_on_open_allowed")
	private boolean isPickupOnOpenAllowed;

	@SerializedName("temporary_updated_entities")
	private List<Object> temporaryUpdatedEntities;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("available_payment_methods")
	private List<Object> availablePaymentMethods;

	@SerializedName("tax_number")
	private String taxNumber;

	@SerializedName("is_fraud_detection_enabled")
	private boolean isFraudDetectionEnabled;

	@SerializedName("has_promotions")
	private boolean hasPromotions;

	@SerializedName("currency")
	private Currency currency;

	@SerializedName("kiosk_receipt_footer")
	private String kioskReceiptFooter;

	@SerializedName("address")
	private String address;

	@SerializedName("company_id")
	private int companyId;

	@SerializedName("order_types")
	private List<OrderTypesItem> orderTypes;

	@SerializedName("is_order_regret_enabled")
	private boolean isOrderRegretEnabled;

	@SerializedName("cuisine")
	private String cuisine;

	@SerializedName("is_billable")
	private boolean isBillable;

	@SerializedName("service_charge")
	private int serviceCharge;

	@SerializedName("is_monitoring_enabled")
	private boolean isMonitoringEnabled;

	@SerializedName("use_pos_order_number")
	private boolean usePosOrderNumber;

	@SerializedName("is_calculated_delivery_buffer_used")
	private boolean isCalculatedDeliveryBufferUsed;

	@SerializedName("currency_id")
	private int currencyId;

	public Country getCountry(){
		return country;
	}

	public boolean isIsSmartOrdersEnabled(){
		return isSmartOrdersEnabled;
	}

	public List<Integer> getUsedPriceConfigurations(){
		return usedPriceConfigurations;
	}

	public List<AreasItem> getAreas(){
		return areas;
	}

	public int getLanguageId(){
		return languageId;
	}

	public boolean isWillOpen(){
		return willOpen;
	}

	public Object getStoreGroupId(){
		return storeGroupId;
	}

	public String getCalculationMethod(){
		return calculationMethod;
	}

	public Translations getTranslations(){
		return translations;
	}

	public int getTipMax(){
		return tipMax;
	}

	public boolean isIsShownInDirectory(){
		return isShownInDirectory;
	}

	public Object getDeliveryIntegrationProperties(){
		return deliveryIntegrationProperties;
	}

	public boolean isIsThreedsEnabled(){
		return isThreedsEnabled;
	}

	public int getId(){
		return id;
	}

	public int getState(){
		return state;
	}

	public List<Object> getServingTimes(){
		return servingTimes;
	}

	public double getLongitude(){
		return longitude;
	}

	public String getZip(){
		return zip;
	}

	public boolean isHasDiscounts(){
		return hasDiscounts;
	}

	public Image getImage(){
		return image;
	}

	public boolean isAllowItemComments(){
		return allowItemComments;
	}

	public boolean isIsOpen(){
		return isOpen;
	}

	public PriceConfiguration getPriceConfiguration(){
		return priceConfiguration;
	}

	public String getParentType(){
		return parentType;
	}

	public int getBrandId(){
		return brandId;
	}

	public String getPhone(){
		return phone;
	}

	public int getParentId(){
		return parentId;
	}

	public int getDefaultDeliveryBuffer(){
		return defaultDeliveryBuffer;
	}

	public String getName(){
		return name;
	}

	public Integration getIntegration(){
		return integration;
	}

	public int getPickupTime(){
		return pickupTime;
	}

	public int getCountryId(){
		return countryId;
	}

	public String getCode(){
		return code;
	}

	public Object getChainId(){
		return chainId;
	}

	public String getCity(){
		return city;
	}

	public Timezone getTimezone(){
		return timezone;
	}

	public String getImprint(){
		return imprint;
	}

	public double getLatitude(){
		return latitude;
	}

	public String getDeliveryTravelType(){
		return deliveryTravelType;
	}

	public String getDescription(){
		return description;
	}

	public int getTipDefault(){
		return tipDefault;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public boolean isHasLoyalty(){
		return hasLoyalty;
	}

	public String getWelcomeMessage(){
		return welcomeMessage;
	}

	public boolean isHasDeliveryIntegration(){
		return hasDeliveryIntegration;
	}

	public String getStoreUrl(){
		return storeUrl;
	}

	public boolean isIsPickupOnOpenAllowed(){
		return isPickupOnOpenAllowed;
	}

	public List<Object> getTemporaryUpdatedEntities(){
		return temporaryUpdatedEntities;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public List<Object> getAvailablePaymentMethods(){
		return availablePaymentMethods;
	}

	public String getTaxNumber(){
		return taxNumber;
	}

	public boolean isIsFraudDetectionEnabled(){
		return isFraudDetectionEnabled;
	}

	public boolean isHasPromotions(){
		return hasPromotions;
	}

	public Currency getCurrency(){
		return currency;
	}

	public String getKioskReceiptFooter(){
		return kioskReceiptFooter;
	}

	public String getAddress(){
		return address;
	}

	public int getCompanyId(){
		return companyId;
	}

	public List<OrderTypesItem> getOrderTypes(){
		return orderTypes;
	}

	public boolean isIsOrderRegretEnabled(){
		return isOrderRegretEnabled;
	}

	public String getCuisine(){
		return cuisine;
	}

	public boolean isIsBillable(){
		return isBillable;
	}

	public int getServiceCharge(){
		return serviceCharge;
	}

	public boolean isIsMonitoringEnabled(){
		return isMonitoringEnabled;
	}

	public boolean isUsePosOrderNumber(){
		return usePosOrderNumber;
	}

	public boolean isIsCalculatedDeliveryBufferUsed(){
		return isCalculatedDeliveryBufferUsed;
	}

	public int getCurrencyId(){
		return currencyId;
	}
}