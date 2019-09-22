package cput.ac.za.factories.privateSessions;


import cput.ac.za.domain.privateSession.PrivateSpeed;
import cput.ac.za.util.Helper;

import java.util.Date;

public class PrivateSpeedFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PrivateSpeedFactory.class);

    public static PrivateSpeed getPrivateSpeed(Date date, String type) {
        return new PrivateSpeed.Builder()
                .id(Helper.generateRandomGivenSuffix(SUFFIX))
                .date(date)
                .type(type)
                .build();
    }
}
