package com.mik.gwt.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by Сокол on 13.03.2016.
 */
public class WelcomePlace extends AppPlace {

    private String token;

    public WelcomePlace(String token) {
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }
    public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {

        public String getToken(WelcomePlace place) {
            return place.getToken();
        }

        public WelcomePlace getPlace(String token) {
            return new WelcomePlace(token);
        }
    }
}
