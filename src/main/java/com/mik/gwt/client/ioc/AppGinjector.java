package com.mik.gwt.client.ioc;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mik.gwt.client.WelcomeGWT;

@GinModules(AppInjectorModule.class)
public interface AppGinjector extends Ginjector {
//	ClientFactory getClientFactory();
	/** Provide injection for the entrypoint */
//	void inject(WelcomeGWT welcomeGWT);
	ActivityManager getActivityManager();

	SimplePanel getWidget();

	PlaceHistoryHandler getPlaceHistoryHandler();
}
