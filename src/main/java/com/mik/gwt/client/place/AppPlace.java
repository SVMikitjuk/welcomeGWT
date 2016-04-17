package com.mik.gwt.client.place;

import com.google.gwt.place.shared.Place;

public abstract class AppPlace extends Place {

    private String placeName;

    public void setPlaceName(String token) {
        this.placeName = token;
    }

    public String getPlaceName() {
        return placeName;
    }
}
