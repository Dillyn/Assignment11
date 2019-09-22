package cput.ac.za.factories.classes;

import cput.ac.za.domain.classes.Speed;
import cput.ac.za.util.Helper;

public class SpeedClassFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SpeedClassFactory.class);

    public static Speed getClasss(String name) {
        return new Speed.Builder()
                .idClass(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .build();
    }
}
