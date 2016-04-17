package com.mik.gwt.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class LoginPlace extends AppPlace {

    @Prefix("login")
    public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

        private final Provider<LoginPlace> placeProvider;

        @Inject
        public Tokenizer(Provider<LoginPlace> placeProvider) {
            this.placeProvider = placeProvider;
        }

        public String getToken(LoginPlace place) {
            return place.getPlaceName();
        }

        public LoginPlace getPlace(String token) {
            LoginPlace place = placeProvider.get();
            place.setPlaceName(token);
            return place;
           // return new LoginPlace(token);
        }
    }
}
