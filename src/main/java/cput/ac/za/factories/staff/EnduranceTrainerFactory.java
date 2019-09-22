package cput.ac.za.factories.staff;

import cput.ac.za.domain.staff.EnduranceTrainer;
import cput.ac.za.util.Helper;

public class EnduranceTrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(EnduranceTrainerFactory.class);

    public static EnduranceTrainer getEnduranceTrainer( String name, String lastName, String title) {
        return new EnduranceTrainer.Builder()
                .idEnduranceTrainer(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}