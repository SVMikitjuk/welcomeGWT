package com.mik.gwt.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mik.gwt.client.ClientFactory;
import com.mik.gwt.client.place.LoginPlace;
import com.mik.gwt.client.place.WelcomePlace;
import com.mik.gwt.client.ui.welcome.WelcomeView;
import com.mik.gwt.server.util.Welcome;

public class WelcomeActivity extends AbstractActivity implements WelcomeView.Presenter {

	private ClientFactory clientFactory;
	private String name;

	public WelcomeActivity(WelcomePlace place, ClientFactory clientFactory) {
		this.name = place.getToken();
		this.clientFactory = clientFactory;
	}

	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		WelcomeView welcomeView = clientFactory.getWelcomeView();
		//welcomeView.setName(name);
		welcomeView.setPresenter(this);
		containerWidget.setWidget(welcomeView.asWidget());
	}

	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	public void logout() {
		goTo(new LoginPlace("login"));
	}
}
