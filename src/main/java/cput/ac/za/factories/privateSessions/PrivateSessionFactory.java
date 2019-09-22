package cput.ac.za.factories.privateSessions;

import cput.ac.za.domain.privateSession.PrivateSession;
import cput.ac.za.util.Helper;


import java.util.Date;

public class PrivateSessionFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PrivateSessionFactory.class);

    public static PrivateSession getPrivateSession(Date date,String type) {
            return new PrivateSession.Builder()
                    .id(Helper.generateRandomGivenSuffix(SUFFIX))
                    .date(date)
                    .type(type)
                    .build();
        }
    }
