package com.mik.gwt.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by mikitjuk on 18.01.16.
 */
public interface WelcomeEventHandler extends EventHandler {
    void onLogout(WelcomeEvent welcomeEvent);
}
