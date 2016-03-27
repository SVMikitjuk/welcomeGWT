package com.mik.gwt.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.mik.gwt.client.ClientFactory;
import com.mik.gwt.client.place.LoginPlace;
import com.mik.gwt.client.place.WelcomePlace;

public class AppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		if (place instanceof LoginPlace)
			return new LoginActivity((LoginPlace) place, clientFactory);
		else if (place instanceof WelcomePlace)
			return new WelcomeActivity((WelcomePlace) place, clientFactory);

		return null;
	}
}
