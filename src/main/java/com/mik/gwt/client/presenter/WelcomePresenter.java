package com.mik.gwt.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.mik.gwt.client.event.WelcomeEvent;
import com.mik.gwt.client.ui.welcome.WelcomeViewImpl;

/**
 * Created by mikitjuk on 18.01.16.
 */
public class WelcomePresenter implements Presenter {
    private final HandlerManager eventBus;
    private final WelcomeViewImpl view;

    public WelcomePresenter(HandlerManager eventBus, WelcomeViewImpl view) {
        this.eventBus = eventBus;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void go(final HasWidgets container) {
        container.clear();
        container.add(view.asWidget());
    }

    public void logout() {
        eventBus.fireEvent(new WelcomeEvent());
    }
}
