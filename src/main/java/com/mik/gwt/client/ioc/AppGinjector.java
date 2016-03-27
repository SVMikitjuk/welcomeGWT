package com.mik.gwt.client.ioc;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.mik.gwt.client.ClientFactory;

@GinModules(AppInjectorModule.class)
public interface AppGinjector extends Ginjector {

	ClientFactory getClientFactory();
}
