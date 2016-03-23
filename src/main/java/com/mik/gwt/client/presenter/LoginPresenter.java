package com.mik.gwt.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.event.LoginEvent;
import com.mik.gwt.client.ui.login.LoginViewImpl;
import com.mik.gwt.shared.Response;
import com.mik.gwt.shared.ResponseStat;

import java.util.Date;

/**
 * Created by mikitjuk on 18.01.16.
 */
public class LoginPresenter implements Presenter{

    private final WelcomeServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final LoginViewImpl view;

    public LoginPresenter(WelcomeServiceAsync rpcService, HandlerManager eventBus, LoginViewImpl view) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.view = view;
      //  this.view.setPresenter(this);
    }

    public void go(final HasWidgets container) {
        container.clear();
        container.add(view.asWidget());
    }

    // обработчик входа
    public void loginButtonClicked(String user, String password){
        String locale = LocaleInfo.getCurrentLocale().getLocaleName();

        rpcService.loginServer(user, password, locale, new Date(), new AsyncCallback<Response>() {
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            public void onSuccess(Response result) {
                if (result.getStat() == ResponseStat.access)
                    eventBus.fireEvent(new LoginEvent(result.getMessage()));
                else if (result.getStat() == ResponseStat.denied)
                    Window.alert(result.getMessage());
            }
        });
    }
}
