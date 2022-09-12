package com.demo.menuapp.data.mappers;

import android.content.res.Resources;
import android.text.TextUtils;

import com.demo.menuapp.R;
import com.demo.menuapp.data.model.requestresponse.venues.Image;
import com.demo.menuapp.data.model.requestresponse.venues.Venue;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesItem;
import com.demo.menuapp.ui.view.VenueViewItem;

import java.util.Locale;

public class VenueMappers {
    public static VenueViewItem venueItemToVenueViewItem(Resources resources, VenuesItem venuesItem) {
        Venue venue = venuesItem.getVenue();
        String name = venue != null ? venue.getName() : null;
        String description = venue != null ? venue.getDescription() : null;
        String welcomeMessage = venue != null ? venue.getWelcomeMessage() : null;
        String distance = formatDistance(venuesItem.getDistance());
        String address = venue != null ? formatAddress(venue) : null;
        String status = venue != null ? createStatus(resources, venue) : null;
        String imageUrl = venue != null ? getImageUrl(venue.getImage()) : null;
        boolean enabled = venue != null && venue.isIsOpen();
        return new VenueViewItem(
                name,
                description,
                welcomeMessage,
                distance,
                address,
                status,
                imageUrl,
                enabled);
    }

    private static String getImageUrl(Image image) {
        return image != null ? image.getThumbnailMedium() : null;
    }

    private static String createStatus(Resources resources, Venue venue) {
        return venue.isIsOpen()
                ? resources.getString(R.string.venue_status_open)
                : resources.getString(R.string.venue_status_closed);
    }

    private static String formatAddress(Venue venue) {
        StringBuilder builder = new StringBuilder();
        if(!TextUtils.isEmpty(venue.getAddress())) {
            builder.append(venue.getAddress());
        }
        if(!TextUtils.isEmpty(venue.getCity())) {
            if(builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(venue.getCity());
        }
        return builder.toString();
    }

    private static String formatDistance(double distanceMeters) {
        if(distanceMeters > 1000.0) {
            return String.format(Locale.getDefault(), "%2f", distanceMeters / 1000.0) + "km";
        }
        return String.format(Locale.getDefault(), "%2f", distanceMeters) + "m" ;
    }
}
