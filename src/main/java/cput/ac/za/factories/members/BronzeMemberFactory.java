package cput.ac.za.factories.members;

import cput.ac.za.domain.members.Bronze;
import cput.ac.za.util.Helper;


public class BronzeMemberFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(BronzeMemberFactory.class);

    public static Bronze getClasss(String name, String lastName) {
        return new Bronze.Builder()
                .idBronze(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .build();
    }
}

