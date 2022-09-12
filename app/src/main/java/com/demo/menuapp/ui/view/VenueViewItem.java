package com.demo.menuapp.ui.view;

import android.os.Parcel;
import android.os.Parcelable;

public class VenueViewItem implements Parcelable {
    private final String name;
    private final String description;
    private final String welcomeMessage;
    private final String distance;
    private final String address;
    private final String status;
    private final String imageUrl;
    private final boolean enabled;

    public VenueViewItem(String name, String description, String welcomeMessage, String distance, String address, String status, String imageUrl, boolean enabled) {
        this.name = name;
        this.description = description;
        this.welcomeMessage = welcomeMessage;
        this.distance = distance;
        this.address = address;
        this.status = status;
        this.imageUrl = imageUrl;
        this.enabled = enabled;
    }

    protected VenueViewItem(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.welcomeMessage = in.readString();
        this.distance = in.readString();
        this.address = in.readString();
        this.status = in.readString();
        this.imageUrl = in.readString();
        this.enabled = in.readByte() != 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getDistance() {
        return distance;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.welcomeMessage);
        dest.writeString(this.distance);
        dest.writeString(this.address);
        dest.writeString(this.status);
        dest.writeString(this.imageUrl);
        dest.writeByte(this.enabled ? (byte) 1 : (byte) 0);
    }

    public static final Parcelable.Creator<VenueViewItem> CREATOR = new Parcelable.Creator<VenueViewItem>() {
        @Override
        public VenueViewItem createFromParcel(Parcel source) {
            return new VenueViewItem(source);
        }

        @Override
        public VenueViewItem[] newArray(int size) {
            return new VenueViewItem[size];
        }
    };
}
