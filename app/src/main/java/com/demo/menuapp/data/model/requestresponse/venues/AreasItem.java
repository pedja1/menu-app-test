package com.demo.menuapp.data.model.requestresponse.venues;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AreasItem{

	@SerializedName("type_id")
	private int typeId;

	@SerializedName("order_types")
	private List<OrderTypesItem> orderTypes;

	@SerializedName("is_table_supported")
	private int isTableSupported;

	@SerializedName("reference_type")
	private String referenceType;

	@SerializedName("delivery_times")
	private List<Object> deliveryTimes;

	@SerializedName("singular_point_id")
	private int singularPointId;

	@SerializedName("tablet")
	private Tablet tablet;

	@SerializedName("use_tablet")
	private boolean useTablet;

	@SerializedName("pos_id")
	private Object posId;

	@SerializedName("name")
	private String name;

	@SerializedName("delivery_area_maps")
	private List<DeliveryAreaMapsItem> deliveryAreaMaps;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private int state;

	@SerializedName("venue_id")
	private int venueId;

	@SerializedName("menu_id")
	private int menuId;

	@SerializedName("properties")
	private Properties properties;

	@SerializedName("table_pos_id")
	private Object tablePosId;

	@SerializedName("singular_point_input_type")
	private String singularPointInputType;

	public int getTypeId(){
		return typeId;
	}

	public List<OrderTypesItem> getOrderTypes(){
		return orderTypes;
	}

	public int getIsTableSupported(){
		return isTableSupported;
	}

	public String getReferenceType(){
		return referenceType;
	}

	public List<Object> getDeliveryTimes(){
		return deliveryTimes;
	}

	public int getSingularPointId(){
		return singularPointId;
	}

	public Tablet getTablet(){
		return tablet;
	}

	public boolean isUseTablet(){
		return useTablet;
	}

	public Object getPosId(){
		return posId;
	}

	public String getName(){
		return name;
	}

	public List<DeliveryAreaMapsItem> getDeliveryAreaMaps(){
		return deliveryAreaMaps;
	}

	public int getId(){
		return id;
	}

	public int getState(){
		return state;
	}

	public int getVenueId(){
		return venueId;
	}

	public int getMenuId(){
		return menuId;
	}

	public Properties getProperties(){
		return properties;
	}

	public Object getTablePosId(){
		return tablePosId;
	}

	public String getSingularPointInputType(){
		return singularPointInputType;
	}
}