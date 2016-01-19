package com.mik.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by mikitjuk on 18.01.16.
 */
public class WelcomeEvent extends GwtEvent<WelcomeEventHandler> {

    public static Type<WelcomeEventHandler> TYPE = new Type<WelcomeEventHandler>();

    @Override
    public Type<WelcomeEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(WelcomeEventHandler handler) {
        handler.onLogout(this);
    }
}
