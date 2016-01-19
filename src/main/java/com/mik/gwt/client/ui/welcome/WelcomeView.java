package com.mik.gwt.client.ui.welcome;

import com.google.gwt.user.client.ui.IsWidget;
import com.mik.gwt.client.presenter.WelcomePresenter;

/**
 * Created by mikitjuk on 18.01.16.
 */
public interface WelcomeView extends IsWidget {
    void setPresenter(WelcomePresenter presenter);
}
