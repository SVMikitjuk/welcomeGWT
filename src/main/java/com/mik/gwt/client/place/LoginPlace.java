package com.mik.gwt.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class LoginPlace extends AppPlace {
    private static final String VIEW_HISTORY_TOKEN = "login";

    @Prefix(VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

//        private final Provider<LoginPlace> placeProvider;
//
//        @Inject
//        public Tokenizer(Provider<LoginPlace> placeProvider) {
//            this.placeProvider = placeProvider;
//        }

        public String getToken(LoginPlace place) {
            return "";
        }

        public LoginPlace getPlace(String token) {
//            LoginPlace place = placeProvider.get();
//            place.setPlaceName(token);
//            return place;
            return new LoginPlace();
           // return placeProvider.get();
        }
    }
}
