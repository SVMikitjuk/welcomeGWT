package com.mik.gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.mik.gwt.client.activity.AppActivityMapper;
import com.mik.gwt.client.place.AppPlaceHistoryMapper;
import com.mik.gwt.client.place.LoginPlace;
import com.mik.gwt.client.service.WelcomeService;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.ui.footer.FooterView;
import com.mik.gwt.client.ui.header.HeaderView;
import com.mik.gwt.client.ui.login.LoginViewImpl;

public class WelcomeGWT implements EntryPoint {

    private Place defaultPlace = new LoginPlace("login");
    private SimplePanel appWidget = new SimplePanel();

    public void onModuleLoad() {

//        HandlerManager eventBus = new HandlerManager(null);

        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

     //   WelcomeServiceAsync rpcService = GWT.create(WelcomeService.class);
     //   AppController appViewer = new AppController(rpcService, eventBus);

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        //RootPanel.get().add(appWidget);
        // Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();


       // AppController appViewer = new AppController(rpcService, eventBus);
        RootPanel.get("header").add(new HeaderView());
        RootPanel.get("main").add(new LoginViewImpl());
        RootPanel.get("footer").add(new FooterView());
       // appViewer.initMainContainer(RootPanel.get("main"));
       // appViewer.initStartPage(RootPanel.get("header"), RootPanel.get("footer"));

        //
//        ClientFactory clientFactory = GWT.create(ClientFactory.class);
//        EventBus eventBus = clientFactory.getEventBus();
//        PlaceController placeController = clientFactory.getPlaceController();
//       // AppController appViewer = new AppController(clientFactory.getWelcomeServiceAsync(), eventBus);


    }
}
