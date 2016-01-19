package com.mik.gwt.client.ui.login;

import com.google.gwt.user.client.ui.IsWidget;
import com.mik.gwt.client.presenter.LoginPresenter;

/**
 * Created by mikitjuk on 18.01.16.
 */
public interface LoginView extends IsWidget {
    void setPresenter(LoginPresenter loginPresenter);
}
