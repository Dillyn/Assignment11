package cput.ac.za.factories.privateSessions;

import cput.ac.za.domain.privateSession.PrivateStrength;
import cput.ac.za.util.Helper;

import java.util.Date;

public class PrivateStrengthFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PrivateStrengthFactory.class);

    public static PrivateStrength getPrivateStrength(Date date, String type) {
        return new PrivateStrength.Builder()
                .id(Helper.generateRandomGivenSuffix(SUFFIX))
                .date(date)
                .type(type)
                .build();
    }
}
