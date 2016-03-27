package com.mik.gwt.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.mik.gwt.client.event.LoginEvent;
import com.mik.gwt.client.event.LoginEventHandler;
import com.mik.gwt.client.event.WelcomeEvent;
import com.mik.gwt.client.event.WelcomeEventHandler;
import com.mik.gwt.client.presenter.LoginPresenter;
import com.mik.gwt.client.presenter.Presenter;
import com.mik.gwt.client.presenter.WelcomePresenter;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.ui.footer.FooterView;
import com.mik.gwt.client.ui.header.HeaderView;
import com.mik.gwt.client.ui.login.LoginViewImpl;
import com.mik.gwt.client.ui.welcome.WelcomeViewImpl;

/**
 * Created by mikitjuk on 18.01.16.
 */
public class AppController {
    private final EventBus eventBus;
    private final WelcomeServiceAsync rpcService;
    private HasWidgets main;

    public AppController(WelcomeServiceAsync rpcService, EventBus eventBus) {
        this.eventBus = eventBus;
        this.rpcService = rpcService;
        bind();
    }

    // назначаем обрабработчиков действий на страницах
    private void bind() {
        eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
            @Override
            public void onLogin(LoginEvent event) {
                doLogin(event.getResult());
            }
        });

        eventBus.addHandler(WelcomeEvent.TYPE, new WelcomeEventHandler() {

            public void onLogout(WelcomeEvent event) {
                doLogout();
            }
        });
    }

    private void doLogin(String result) {
//        Presenter presenter = new WelcomePresenter(eventBus, new WelcomeViewImpl(result));
//        presenter.go(main);
    }

    private void doLogout() {
        setStartPage();
    }

    // инициализация основного контейнера
    public void initMainContainer(RootPanel main) {
        this.main = main;
    }

    // инициализация статических контейнеров и установка начальной страницы
    public void initStartPage(RootPanel header, RootPanel footer) {
        header.add(new HeaderView());
        footer.add(new FooterView());
        setStartPage();
    }

    private void setStartPage() {
//        Presenter presenter = new LoginPresenter(rpcService, eventBus, new LoginViewImpl());
//        presenter.go(main);
    }
}
