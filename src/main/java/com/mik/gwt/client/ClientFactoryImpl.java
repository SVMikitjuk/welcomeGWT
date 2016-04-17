package com.mik.gwt.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.mik.gwt.client.service.WelcomeService;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.ui.login.LoginView;
import com.mik.gwt.client.ui.login.LoginViewImpl;
import com.mik.gwt.client.ui.welcome.WelcomeView;
import com.mik.gwt.client.ui.welcome.WelcomeViewImpl;

public class ClientFactoryImpl implements ClientFactory {

	@Inject
	private EventBus eventBus;
	private static final WelcomeServiceAsync rpcService = GWT.create(WelcomeService.class);
	private PlaceController placeController;
	@Inject
	ActivityMapper activityManager;
	@Inject
	private LoginView loginView;
	@Inject
	private WelcomeView welcomeView;

	@Inject
	public  ClientFactoryImpl(EventBus eventBus, PlaceController placeController, ActivityMapper activityManager){//, final Provider<MainPanel> mainPanelProvider){
		this.eventBus = eventBus;
		this.placeController = placeController;
		this.activityManager = activityManager;
		//this.mainPanelProvider = mainPanelProvider;
	}
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
