package cput.ac.za.repositories.staff.impli;



import cput.ac.za.domain.staff.SpeedTrainer;
import cput.ac.za.repositories.staff.SpeedTrainerRepository;

import java.util.HashSet;
import java.util.Set;

public class SpeedTrainerRepositoryImpli implements SpeedTrainerRepository {
    private static SpeedTrainerRepository trainerRepository = null;
    private Set<SpeedTrainer> trainerDB;

    private SpeedTrainerRepositoryImpli() {
        this.trainerDB = new HashSet<>();
    }

    private SpeedTrainer findClass(String trainerId) {
        return this.trainerDB.stream()
                .filter(trainer1 -> trainer1.getIdSpeedTrainer().trim().equals(trainerId))
                .findAny()
                .orElse(null);
    }

    public static SpeedTrainerRepository speedTrainerRepository() {
        if (trainerRepository == null) trainerRepository = new SpeedTrainerRepositoryImpli();
        return trainerRepository;
    }

    @Override
    public SpeedTrainer create(SpeedTrainer trainer) {
        this.trainerDB.add(trainer);
        return trainer;
    }


    @Override
    public SpeedTrainer read(String trainerId) {
        SpeedTrainer trainer = findClass(trainerId);
        return trainer;
    }


    @Override
    public SpeedTrainer update(SpeedTrainer trainer) {
        SpeedTrainer toDelete = findClass(trainer.getIdSpeedTrainer());
        if(toDelete != null) {
            this.trainerDB.remove(toDelete);
            return create(trainer);
        }
        return null;
    }


    @Override
    public void delete(String trainerId) {
        SpeedTrainer trainer = findClass(trainerId);
        if (trainer != null) this.trainerDB.remove(trainer);
    }


    @Override
    public Set<SpeedTrainer> getAll() {
        return this.trainerDB;
    }
}
