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
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.mik.gwt.client.activity.AppActivityMapper;
import com.mik.gwt.client.ioc.AppGinjector;
import com.mik.gwt.client.place.AppPlaceHistoryMapper;
import com.mik.gwt.client.place.LoginPlace;
import com.mik.gwt.client.service.WelcomeService;
import com.mik.gwt.client.service.WelcomeServiceAsync;
import com.mik.gwt.client.ui.footer.FooterView;
import com.mik.gwt.client.ui.header.HeaderView;
import com.mik.gwt.client.ui.login.LoginViewImpl;

public class WelcomeGWT implements EntryPoint {

//    private Place defaultPlace = new LoginPlace("login");
    //private SimplePanel appWidget = new SimplePanel();
   // private final AppGinjector injector = GWT.create(AppGinjector.class);

//    @Inject
//    PlaceHistoryHandler historyHandler;
 //   @Inject
//    ActivityMapper activityManager;

    public void onModuleLoad() {
        AppGinjector injector = GWT.create(AppGinjector.class);
      //  injector.inject(this);

        final SimplePanel activityDisplay = injector.getWidget();
        injector.getActivityManager().setDisplay(activityDisplay);


        //ClientFactory clientFactory = injector.getClientFactory();
//        EventBus eventBus = clientFactory.getEventBus();
//        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
       // ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        //ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
      //  activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
//        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
//        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
//        historyHandler.register(placeController, eventBus, defaultPlace);

        RootPanel.get("header").add(new HeaderView());
        RootPanel.get("main").add(activityDisplay);
        RootPanel.get("footer").add(new FooterView());

        injector.getPlaceHistoryHandler().handleCurrentHistory();
    }
}
