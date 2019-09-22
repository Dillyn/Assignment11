package cput.ac.za.factories.staff;

import cput.ac.za.domain.staff.StrengthTrainer;
import cput.ac.za.util.Helper;

public class StrengthTrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StrengthTrainerFactory.class);

    public static StrengthTrainer getStrengthTrainer( String name, String lastName, String title) {
        return new StrengthTrainer.Builder()
                .idStrengthTrainer(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
