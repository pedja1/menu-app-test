package com.demo.menuapp.data.model.requestresponse.venues;

import com.google.gson.annotations.SerializedName;

public class Integration{

	@SerializedName("is_windows_pos")
	private boolean isWindowsPos;

	@SerializedName("type_id")
	private int typeId;

	@SerializedName("support_combo_meals")
	private boolean supportComboMeals;

	@SerializedName("pos_modifier_group_type")
	private int posModifierGroupType;

	@SerializedName("id")
	private int id;

	@SerializedName("max_comment_limit")
	private int maxCommentLimit;

	@SerializedName("reference_type")
	private String referenceType;

	public boolean isIsWindowsPos(){
		return isWindowsPos;
	}

	public int getTypeId(){
		return typeId;
	}

	public boolean isSupportComboMeals(){
		return supportComboMeals;
	}

	public int getPosModifierGroupType(){
		return posModifierGroupType;
	}

	public int getId(){
		return id;
	}

	public int getMaxCommentLimit(){
		return maxCommentLimit;
	}

	public String getReferenceType(){
		return referenceType;
	}
}