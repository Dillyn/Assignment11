package cput.ac.za.factories.privateSessions;

import cput.ac.za.domain.privateSession.PrivateEndurance;
import cput.ac.za.util.Helper;

import java.util.Date;

public class PrivateEnduranceFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PrivateEnduranceFactory.class);

    public static PrivateEndurance getPrivateEndurance(Date date, String type) {
        return new PrivateEndurance.Builder()
                .id(Helper.generateRandomGivenSuffix(SUFFIX))
                .date(date)
                .type(type)
                .build();
    }
}

