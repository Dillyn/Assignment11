package cput.ac.za.factories.studio;

import cput.ac.za.domain.studio.Studio;
import cput.ac.za.util.Helper;

public class StudioFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StudioFactory.class);

    public static Studio getStudio(String name) {
        return new Studio.Builder()
                .id(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .build();
    }
}
