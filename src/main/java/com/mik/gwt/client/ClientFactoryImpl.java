package com.mik.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.mik.gwt.client.service.WelcomeService;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.ui.login.LoginView;
import com.mik.gwt.client.ui.login.LoginViewImpl;
import com.mik.gwt.client.ui.welcome.WelcomeView;
import com.mik.gwt.client.ui.welcome.WelcomeViewImpl;

public class ClientFactoryImpl implements ClientFactory {
	private static final EventBus eventBus = new SimpleEventBus();
	private static final WelcomeServiceAsync rpcService = GWT.create(WelcomeService.class);
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final LoginView loginView = new LoginViewImpl();
	private static final WelcomeView welcomeView = new WelcomeViewImpl();

	public EventBus getEventBus()
	{
		return eventBus;
	}

	public WelcomeServiceAsync getWelcomeServiceAsync() {
		return rpcService;
	}

	public LoginView getLoginView()
	{
		return loginView;
	}

	public PlaceController getPlaceController()
	{
		return placeController;
	}

	public WelcomeView getWelcomeView()
	{
		return welcomeView;
	}

}
