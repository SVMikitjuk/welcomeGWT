package com.mik.gwt.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.ui.login.LoginView;
import com.mik.gwt.client.ui.welcome.WelcomeView;

public interface ClientFactory {
	EventBus getEventBus();
	WelcomeServiceAsync getWelcomeServiceAsync();
	PlaceController getPlaceController();
	LoginView getLoginView();
	WelcomeView getWelcomeView();
}
