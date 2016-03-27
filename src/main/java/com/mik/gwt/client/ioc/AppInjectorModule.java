package com.mik.gwt.client.ioc;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.mik.gwt.client.activity.AppActivityMapper;
import com.mik.gwt.client.activity.LoginActivity;
import com.mik.gwt.client.activity.WelcomeActivity;
import com.mik.gwt.client.place.AppPlaceHistoryMapper;
import com.mik.gwt.client.ui.login.LoginView;
import com.mik.gwt.client.ui.login.LoginViewImpl;
import com.mik.gwt.client.ui.welcome.WelcomeView;
import com.mik.gwt.client.ui.welcome.WelcomeViewImpl;

public class AppInjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

        bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
        bind(WelcomeView.class).to(WelcomeViewImpl.class).in(Singleton.class);

        bind(AppActivityMapper.class).in(Singleton.class);
        bind(AppPlaceHistoryMapper.class).in(Singleton.class);

        install(new GinFactoryModuleBuilder()
                .implement(LoginActivity.class, LoginActivity.class)
      .implement(WelcomeActivity.class, WelcomeActivity.class)
                .build(ActivityFactory.class));
    }

    @Singleton
    @Provides
    PlaceController providePlaceController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }

    @Singleton
    @Provides
    ActivityManager provideActivityManager(ActivityMapper mapper, EventBus eventBus) {
        return new ActivityManager(mapper, eventBus);
    }

    @Singleton
    @Provides
    PlaceHistoryHandler providePlaceHistoryHandler(PlaceHistoryMapper mapper,
                                                   PlaceController placeController, EventBus eventBus, @DefaultPlace
                                                           Place defaultPlace) {
        PlaceHistoryHandler phh = new PlaceHistoryHandler(mapper);
        phh.register(placeController, eventBus, defaultPlace);
        return phh;
    }

}
