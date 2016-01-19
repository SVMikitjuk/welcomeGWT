package com.mik.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;
import com.mik.gwt.client.service.WelcomeService;
import com.mik.gwt.client.service.WelcomeServiceAsync;

public class WelcomeGWT implements EntryPoint {

    public void onModuleLoad() {
        WelcomeServiceAsync rpcService = GWT.create(WelcomeService.class);
        HandlerManager eventBus = new HandlerManager(null);

        AppController appViewer = new AppController(rpcService, eventBus);
        appViewer.initMainContainer(RootPanel.get("main"));
        appViewer.initStartPage(RootPanel.get("header"), RootPanel.get("footer"));
    }
}
