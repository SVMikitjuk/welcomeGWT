package com.mik.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.Date;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface WelcomeService extends RemoteService {
  String loginServer(String name, String password, String locale, Date date) throws IllegalArgumentException;
}
