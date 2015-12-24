package com.mik.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by mikitjuk on 22.12.15.
 */
public class HeaderForm extends Composite {
    interface HeaderFormUiBinder extends UiBinder<Widget, HeaderForm> {
    }

    private static HeaderFormUiBinder ourUiBinder = GWT.create(HeaderFormUiBinder.class);

    @UiField
    Image logo;

    public HeaderForm() {
        initWidget(ourUiBinder.createAndBindUi(this));
        logo.setUrl("images/ardas_logo.png");
        logo.setHeight("150px");
    }

}