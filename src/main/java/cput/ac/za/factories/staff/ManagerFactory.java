package cput.ac.za.factories.staff;

import cput.ac.za.domain.staff.Manager;
import cput.ac.za.util.Helper;

public class ManagerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(ManagerFactory.class);

    public static Manager getManager( String name, String lastName, String title) {
        return new Manager.Builder()
                .idManager(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}