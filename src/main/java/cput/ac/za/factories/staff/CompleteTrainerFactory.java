package cput.ac.za.factories.staff;

import cput.ac.za.domain.staff.CompleteTrainer;
import cput.ac.za.util.Helper;

public class CompleteTrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(CompleteTrainerFactory.class);

    public static CompleteTrainer getCompleteTrainer( String name, String lastName, String title) {
        return new CompleteTrainer.Builder()
                .idCompleteTrainer(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
