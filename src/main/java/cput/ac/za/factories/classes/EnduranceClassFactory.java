package cput.ac.za.factories.classes;

import cput.ac.za.domain.classes.Endurance;
import cput.ac.za.util.Helper;

public class EnduranceClassFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(EnduranceClassFactory.class);

    public static Endurance getClasss(String name) {
        return new Endurance.Builder()
                .idClass(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .build();
    }
}
