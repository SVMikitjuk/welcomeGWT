package com.mik.gwt.client.ui.footer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import java.util.Date;

/**
 * Created by mikitjuk on 22.12.15.
 */
public class FooterView extends Composite {

    interface FooterFormUiBinder extends UiBinder<Widget, FooterView> {}
    private static FooterFormUiBinder ourUiBinder = GWT.create(FooterFormUiBinder.class);

    @UiField
    Label footer;

    public FooterView() {
        initWidget(ourUiBinder.createAndBindUi(this));
        footer.setText("@ " + DateTimeFormat.getFormat("yyyy").format(new Date()) + " Ardas Group");
    }
}