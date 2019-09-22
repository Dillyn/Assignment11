package cput.ac.za.factories.classes;

import cput.ac.za.domain.classes.Strength;
import cput.ac.za.util.Helper;

public class StrengthClassFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StrengthClassFactory.class);

    public static Strength getClasss( String name) {
        return new Strength.Builder()
                .idClass(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .build();
    }
}
