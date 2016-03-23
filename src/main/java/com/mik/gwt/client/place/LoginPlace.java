package com.mik.gwt.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class LoginPlace extends AppPlace {

    private String token;

    public LoginPlace(String token) {
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }

    public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

        public String getToken(LoginPlace place) {
            return place.getToken();
        }

        public LoginPlace getPlace(String token) {
            return new LoginPlace(token);
        }
    }
}
