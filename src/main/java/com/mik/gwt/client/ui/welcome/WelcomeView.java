package com.mik.gwt.client.ui.welcome;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.mik.gwt.client.presenter.WelcomePresenter;

/**
 * Created by mikitjuk on 18.01.16.
 */
public interface WelcomeView extends IsWidget {

    void setPresenter(Presenter presenter);
    void setWelcomeUser(String user);

    public interface Presenter {
        void goTo(Place place);
        void logout();
    }
}
