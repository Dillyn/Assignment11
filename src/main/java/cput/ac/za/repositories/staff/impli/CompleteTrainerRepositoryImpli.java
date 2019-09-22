package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.CompleteTrainer;
import cput.ac.za.repositories.staff.CompleteTrainerRepository;

import java.util.HashSet;
import java.util.Set;

public class CompleteTrainerRepositoryImpli implements CompleteTrainerRepository {
    private static CompleteTrainerRepository trainerRepository = null;
    private Set<CompleteTrainer> trainerDB;

    private CompleteTrainerRepositoryImpli() {
        this.trainerDB = new HashSet<>();
    }

    private CompleteTrainer findClass(String trainerId) {
        return this.trainerDB.stream()
                .filter(trainer1 -> trainer1.getIdCompleteTrainer().trim().equals(trainerId))
                .findAny()
                .orElse(null);
    }

    public static CompleteTrainerRepository trainerRepository() {
        if (trainerRepository == null) trainerRepository = new CompleteTrainerRepositoryImpli();
        return trainerRepository;
    }

    @Override
    public CompleteTrainer create(CompleteTrainer trainer) {
        this.trainerDB.add(trainer);
        return trainer;
    }


    @Override
    public CompleteTrainer read(String trainerId) {
        CompleteTrainer trainer = findClass(trainerId);
        return trainer;
    }


    @Override
    public CompleteTrainer update(CompleteTrainer trainer) {
        CompleteTrainer toDelete = findClass(trainer.getIdCompleteTrainer());
        if(toDelete != null) {
            this.trainerDB.remove(toDelete);
            return create(trainer);
        }
        return null;
    }


    @Override
    public void delete(String trainerId) {
        CompleteTrainer trainer = findClass(trainerId);
        if (trainer != null) this.trainerDB.remove(trainer);
    }


    @Override
    public Set<CompleteTrainer> getAll() {
        return this.trainerDB;
    }
}
