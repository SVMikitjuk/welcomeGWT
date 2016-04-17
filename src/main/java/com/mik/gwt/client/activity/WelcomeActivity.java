package com.mik.gwt.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.mik.gwt.client.place.LoginPlace;
import com.mik.gwt.client.ui.welcome.WelcomeView;

public class WelcomeActivity extends AbstractActivity implements WelcomeView.Presenter {

	@Inject
	WelcomeView welcomeView;
	@Inject
	PlaceController placeController;

	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		welcomeView.setPresenter(this);
		containerWidget.setWidget(welcomeView.asWidget());
	}

	public void goTo(Place place) {
		placeController.goTo(place);
	}

	public void logout() {
		goTo(new LoginPlace());
	}
}
