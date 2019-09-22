package cput.ac.za.factories.classes;

import cput.ac.za.domain.classes.Classs;
import cput.ac.za.util.Helper;

public class ClasssFactory {

    private static final String SUFFIX = Helper.getSuffixFromClassName(ClasssFactory.class);

    public static Classs getClasss( String name) {
        return new Classs.Builder()
                .idClass(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .build();
    }
}
