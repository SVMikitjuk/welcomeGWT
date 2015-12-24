package com.mik.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mik.gwt.client.WelcomeGWT;


/**
 * Created by mikitjuk on 14.12.15.
 * page for welcome
 */
public class WelcomeForm extends Composite {

    interface WelcomeFormUiBinder extends UiBinder<Widget, WelcomeForm> {
    }

    private static WelcomeFormUiBinder ourUiBinder = GWT.create(WelcomeFormUiBinder.class);

    @UiField
    Label welcomeLabel;

    public WelcomeForm() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void setTextWelcome(String result) {
        welcomeLabel.setText(result);
    }

    @UiHandler("logoutLink")
    void logout(ClickEvent e) {

        WelcomeGWT.mainForm.password.setText("");
        WelcomeGWT.mainForm.user.setText("");

        WelcomeGWT.welcomeForm.removeFromParent();
        RootPanel.get("login-form").add(WelcomeGWT.mainForm);
    }

}