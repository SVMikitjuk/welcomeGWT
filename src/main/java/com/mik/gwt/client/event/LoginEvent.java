package com.mik.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by mikitjuk on 18.01.16.
 */
public class LoginEvent extends GwtEvent<LoginEventHandler>{

    public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();
    private final String result;

    public LoginEvent(String user) {
        this.result = user;
    }

    @Override
    public Type<LoginEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LoginEventHandler handler) {
        handler.onLogin(this);
    }

    public String getResult() {
        return result;
    }
}
