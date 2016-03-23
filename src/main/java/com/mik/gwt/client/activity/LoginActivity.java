package com.mik.gwt.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mik.gwt.client.ClientFactory;
import com.mik.gwt.client.event.LoginEvent;
import com.mik.gwt.client.place.LoginPlace;
import com.mik.gwt.client.place.WelcomePlace;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.ui.login.LoginView;
import com.mik.gwt.shared.Response;
import com.mik.gwt.shared.ResponseStat;

import java.util.Date;

public class LoginActivity extends AbstractActivity implements LoginView.Presenter {
	private ClientFactory clientFactory;
	//private final WelcomeServiceAsync rpcService;
	//private final HandlerManager eventBus;
	private String token;

	public LoginActivity(LoginPlace place, ClientFactory clientFactory) {
		this.token = place.getToken();
		this.clientFactory = clientFactory;
	}

	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		LoginView loginView = clientFactory.getLoginView();
		//loginView.setName(token);
		containerWidget.setWidget(loginView.asWidget());
	}

	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	// обработчик входа
	public void login(String user, String password){
		String locale = LocaleInfo.getCurrentLocale().getLocaleName();
		WelcomeServiceAsync serviceAsync = clientFactory.getWelcomeServiceAsync();

		serviceAsync.loginServer(user, password, locale, new Date(), new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			public void onSuccess(Response result) {
				if (result.getStat() == ResponseStat.access) {
					//eventBus.fireEvent(new LoginEvent(result.getMessage()));
					clientFactory.getWelcomeView().setWelcomeUser(result.getMessage());
					goTo(new WelcomePlace("welcome"));
				}else if (result.getStat() == ResponseStat.denied)
					Window.alert(result.getMessage());
			}
		});
	}
}