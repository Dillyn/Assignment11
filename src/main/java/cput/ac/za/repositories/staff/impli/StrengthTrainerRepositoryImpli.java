package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.classes.Strength;
import cput.ac.za.domain.staff.StrengthTrainer;
import cput.ac.za.repositories.staff.StrengthTrainerRepository;

import java.util.HashSet;
import java.util.Set;

public class StrengthTrainerRepositoryImpli implements StrengthTrainerRepository {
    private static StrengthTrainerRepository trainerRepository = null;
    private Set<StrengthTrainer> trainerDB;

    private StrengthTrainerRepositoryImpli() {
        this.trainerDB = new HashSet<>();
    }

    private StrengthTrainer findClass(String trainerId) {
        return this.trainerDB.stream()
                .filter(trainer -> trainer.getIdStrengthTrainer().trim().equals(trainerId))
                .findAny()
                .orElse(null);
    }

    public static StrengthTrainerRepository strengthTrainerRepository() {
        if (trainerRepository == null) trainerRepository = new StrengthTrainerRepositoryImpli();
        return trainerRepository;
    }

    @Override
    public StrengthTrainer create(StrengthTrainer trainer) {
        this.trainerDB.add(trainer);
        return trainer;
    }


    @Override
    public StrengthTrainer read(String trainerId) {
        StrengthTrainer trainer = findClass(trainerId);
        return trainer;
    }


    @Override
    public StrengthTrainer update(StrengthTrainer trainer) {
        StrengthTrainer toDelete = findClass(trainer.getIdStrengthTrainer());
        if(toDelete != null) {
            this.trainerDB.remove(toDelete);
            return create(trainer);
        }
        return null;
    }


    @Override
    public void delete(String trainerId) {
        StrengthTrainer trainer = findClass(trainerId);
        if (trainer != null) this.trainerDB.remove(trainer);
    }


    @Override
    public Set<StrengthTrainer> getAll() {
        return this.trainerDB;
    }
}
