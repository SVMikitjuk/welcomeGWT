package com.mik.gwt.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.mik.gwt.client.place.LoginPlace;
import com.mik.gwt.client.place.WelcomePlace;

public class AppActivityMapper implements ActivityMapper {
	@Inject
	ActivityFactory factory;

	public Activity getActivity(Place place) {
		if (place instanceof LoginPlace)
			return factory.createLoginActivity((LoginPlace) place);
		else if (place instanceof WelcomePlace)
			return factory.createWelcomeActivity((WelcomePlace) place);

		return null;
	}

	public interface ActivityFactory {
		WelcomeActivity createWelcomeActivity(WelcomePlace place);
		LoginActivity createLoginActivity(LoginPlace place);
	}
}
