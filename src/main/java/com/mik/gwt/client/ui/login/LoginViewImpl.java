package com.mik.gwt.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mik.gwt.client.presenter.LoginPresenter;


/**
 * Created by mikitjuk on 14.12.15.
 * page for login
 */
public class LoginViewImpl extends Composite implements LoginView {

    interface LoginFormUiBinder extends UiBinder<Widget, LoginViewImpl> { }

    private static LoginFormUiBinder ourUiBinder = GWT.create(LoginFormUiBinder.class);
    private LoginPresenter loginPresenter;

    @UiField
    TextBox user;
    @UiField
    TextBox password;

    public LoginViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @UiHandler("login")
    void login(ClickEvent e) {
        loginPresenter.loginButtonClicked(user.getValue(), password.getValue());
    }
}