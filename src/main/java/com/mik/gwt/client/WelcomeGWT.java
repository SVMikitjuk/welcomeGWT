package com.mik.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.mik.gwt.client.ui.FooterForm;
import com.mik.gwt.client.ui.HeaderForm;
import com.mik.gwt.client.ui.LoginForm;
import com.mik.gwt.client.ui.WelcomeForm;

public class WelcomeGWT implements EntryPoint {
    public static WelcomeServiceAsync greetingService;

    //основные формы страницы
    public static LoginForm mainForm;
    public static HeaderForm headerForm;
    public static WelcomeForm welcomeForm;
    public static FooterForm footerForm;

    public void onModuleLoad() {

        greetingService = GWT.create(WelcomeService.class);

        mainForm = new LoginForm();
        headerForm = new HeaderForm();
        welcomeForm = new WelcomeForm();
        footerForm = new FooterForm();

        RootPanel.get("header").add(headerForm);
        RootPanel.get("login-form").add(mainForm);
        RootPanel.get("footer").add(footerForm);
    }
}
