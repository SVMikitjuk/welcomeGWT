package com.mik.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mik.gwt.client.WelcomeGWT;

import java.util.Date;


/**
 * Created by mikitjuk on 14.12.15.
 * page for login
 */
public class LoginForm extends Composite {
    interface LoginFormUiBinder extends UiBinder<Widget, LoginForm> {
    }

    private static LoginFormUiBinder ourUiBinder = GWT.create(LoginFormUiBinder.class);

    @UiField
    TextBox user;
    @UiField
    TextBox password;

    public LoginForm() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("login")
    void login(ClickEvent e) {
        String locale = LocaleInfo.getCurrentLocale().getLocaleName();
        WelcomeGWT.greetingService.loginServer(user.getValue(), password.getValue(), locale, new Date(),  new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            public void onSuccess(String result) {
                WelcomeGWT.welcomeForm.setTextWelcome(result);
                WelcomeGWT.mainForm.removeFromParent();
                RootPanel.get("welcome-form").add(WelcomeGWT.welcomeForm);
            }
        });
    }
}