package cput.ac.za.factories.staff;

import cput.ac.za.domain.staff.SpeedTrainer;
import cput.ac.za.util.Helper;

public class SpeedTrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SpeedTrainerFactory.class);

    public static SpeedTrainer getSpeedTrainer( String name, String lastName, String title) {
        return new SpeedTrainer.Builder()
                .idSpeedTrainer(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
