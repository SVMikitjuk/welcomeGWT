package com.mik.gwt.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.mik.gwt.client.place.WelcomePlace;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.ui.login.LoginView;
import com.mik.gwt.client.ui.welcome.WelcomeView;
import com.mik.gwt.shared.Response;
import com.mik.gwt.shared.ResponseStat;

import java.util.Date;

public class LoginActivity extends AbstractActivity implements LoginView.Presenter {

	@Inject
	LoginView loginView;
	@Inject
	WelcomeView welcomeView;
	@Inject
	PlaceController placeController;
	@Inject
	WelcomeServiceAsync serviceAsync;

	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		loginView.setPresenter(this);
		containerWidget.setWidget(loginView.asWidget());
	}

	public void goTo(Place place) {
		placeController.goTo(place);
	}

	public void login(String user, String password){
		String locale = LocaleInfo.getCurrentLocale().getLocaleName();

		serviceAsync.loginServer(user, password, locale, new Date(), new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			public void onSuccess(Response result) {
				if (result.getStat() == ResponseStat.access) {
					welcomeView.setWelcomeUser(result.getMessage());
					goTo(new WelcomePlace());
				}else if (result.getStat() == ResponseStat.denied)
					Window.alert(result.getMessage());
			}
		});
	}
}