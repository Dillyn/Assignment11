package cput.ac.za.factories.staff;

import cput.ac.za.domain.staff.Trainer;
import cput.ac.za.util.Helper;

public class TrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(TrainerFactory.class);

    public static Trainer getTrainer( String name, String lastName, String title) {
        return new Trainer.Builder()
                .idTrainer(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
