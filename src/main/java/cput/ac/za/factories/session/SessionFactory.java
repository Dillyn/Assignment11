package cput.ac.za.factories.session;

import cput.ac.za.domain.session.Session;
import cput.ac.za.util.Helper;

import java.util.Date;

public class SessionFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SessionFactory.class);

    public static Session getSession(Date date) {
        return new Session.Builder()
                .id(Helper.generateRandomGivenSuffix(SUFFIX))
                .date(date)
                .build();
    }
}