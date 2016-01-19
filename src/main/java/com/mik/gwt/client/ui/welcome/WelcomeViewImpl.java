package com.mik.gwt.client.ui.welcome;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.mik.gwt.client.presenter.WelcomePresenter;


/**
 * Created by mikitjuk on 14.12.15.
 * page for welcome
 */
public class WelcomeViewImpl extends Composite implements WelcomeView{

    interface WelcomeFormUiBinder extends UiBinder<Widget, WelcomeViewImpl> { }

    private static WelcomeFormUiBinder ourUiBinder = GWT.create(WelcomeFormUiBinder.class);
    private WelcomePresenter presenter;

    @UiField
    Label welcomeLabel;

    public WelcomeViewImpl(String result) {
        initWidget(ourUiBinder.createAndBindUi(this));
        welcomeLabel.setText(result);
    }

    @Override
    public void setPresenter(WelcomePresenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("logoutLink")
    void logout(ClickEvent e) {
        presenter.logout();
    }

}