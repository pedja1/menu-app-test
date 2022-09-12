package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Tablet{

	@SerializedName("show_kiosk_orders")
	private boolean showKioskOrders;

	@SerializedName("pls_name")
	private Object plsName;

	@SerializedName("last_request_at")
	private String lastRequestAt;

	@SerializedName("use_notifications")
	private int useNotifications;

	@SerializedName("token")
	private String token;

	@SerializedName("area_ids")
	private List<Integer> areaIds;

	@SerializedName("name")
	private String name;

	@SerializedName("kiosk_notification_type")
	private int kioskNotificationType;

	@SerializedName("failure_reported")
	private boolean failureReported;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("is_online")
	private boolean isOnline;

	@SerializedName("venue_id")
	private int venueId;

	@SerializedName("middleware_endpoint")
	private Object middlewareEndpoint;

	@SerializedName("is_critical")
	private boolean isCritical;

	public boolean isShowKioskOrders(){
		return showKioskOrders;
	}

	public Object getPlsName(){
		return plsName;
	}

	public String getLastRequestAt(){
		return lastRequestAt;
	}

	public int getUseNotifications(){
		return useNotifications;
	}

	public String getToken(){
		return token;
	}

	public List<Integer> getAreaIds(){
		return areaIds;
	}

	public String getName(){
		return name;
	}

	public int getKioskNotificationType(){
		return kioskNotificationType;
	}

	public boolean isFailureReported(){
		return failureReported;
	}

	public int getId(){
		return id;
	}

	public int getState(){
		return state;
	}

	public boolean isIsOnline(){
		return isOnline;
	}

	public int getVenueId(){
		return venueId;
	}

	public Object getMiddlewareEndpoint(){
		return middlewareEndpoint;
	}

	public boolean isIsCritical(){
		return isCritical;
	}
}