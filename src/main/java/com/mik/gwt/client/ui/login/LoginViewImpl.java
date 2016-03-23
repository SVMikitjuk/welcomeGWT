package com.mik.gwt.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


/**
 * Created by mikitjuk on 14.12.15.
 * page for login
 */
public class LoginViewImpl extends Composite implements LoginView {

    interface LoginFormUiBinder extends UiBinder<Widget, LoginViewImpl> { }

    private static LoginFormUiBinder ourUiBinder = GWT.create(LoginFormUiBinder.class);
    private Presenter presenter;

    @UiField
    TextBox user;
    @UiField
    TextBox password;

    public LoginViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("login")
    void login(ClickEvent e) {
        presenter.login(user.getValue(), password.getValue());
    }
}