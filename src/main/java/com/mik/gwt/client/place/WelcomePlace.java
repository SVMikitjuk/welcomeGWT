package com.mik.gwt.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class WelcomePlace extends AppPlace {
    private static final String VIEW_HISTORY_TOKEN = "welcome";

    @Prefix(VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {

//        private final Provider<WelcomePlace> placeProvider;
//
//        @Inject
//        public Tokenizer(Provider<WelcomePlace> placeProvider) {
//            this.placeProvider = placeProvider;
//        }

        public String getToken(WelcomePlace place) {
            return "";
        }

        public WelcomePlace getPlace(String token) {
//            WelcomePlace place = placeProvider.get();
//            place.setPlaceName(token);
//            return place;
            return new WelcomePlace();
            //return  placeProvider.get();
        }
    }
}
