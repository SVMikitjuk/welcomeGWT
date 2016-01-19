package com.mik.gwt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mik.gwt.shared.Response;

import java.util.Date;

/**
 * Created by mikitjuk on 18.01.16.
 */
public interface WelcomeServiceAsync {
    void loginServer(String name, String password, String locale, Date date, AsyncCallback<Response> callback);
}
