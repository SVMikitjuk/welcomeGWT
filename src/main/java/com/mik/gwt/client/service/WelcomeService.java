package com.mik.gwt.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mik.gwt.shared.Response;

import java.util.Date;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface WelcomeService extends RemoteService {
  Response loginServer(String name, String password, String locale, Date date);
}
