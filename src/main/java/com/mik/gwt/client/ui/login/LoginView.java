package com.mik.gwt.client.ui.login;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.mik.gwt.client.presenter.LoginPresenter;

/**
 * Created by mikitjuk on 18.01.16.
 */
public interface LoginView extends IsWidget {
    void setPresenter(Presenter loginPresenter);

    public interface Presenter {
        void goTo(Place place);
        void login(String user, String password);
    }
}
