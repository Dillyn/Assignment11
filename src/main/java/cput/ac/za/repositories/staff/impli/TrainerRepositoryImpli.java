package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.Trainer;
import cput.ac.za.repositories.IRepository;
import cput.ac.za.repositories.staff.TrainerRepository;

import java.util.HashSet;
import java.util.Set;

public class TrainerRepositoryImpli implements TrainerRepository {
    private static TrainerRepository trainerRepository = null;
    private Set<Trainer> trainerDB;

    private TrainerRepositoryImpli() {
        this.trainerDB = new HashSet<>();
    }

    private Trainer findClass(String trainerId) {
        return this.trainerDB.stream()
                .filter(trainer1 -> trainer1.getIdTrainer().trim().equals(trainerId))
                .findAny()
                .orElse(null);
    }

    public static TrainerRepository trainerRepository() {
        if (trainerRepository == null) trainerRepository = new TrainerRepositoryImpli();
        return trainerRepository;
    }

    @Override
    public Trainer create(Trainer trainer) {
        this.trainerDB.add(trainer);
        return trainer;
    }


    @Override
    public Trainer read(String trainerId) {
        Trainer trainer = findClass(trainerId);
        return trainer;
    }


    @Override
    public Trainer update(Trainer trainer) {
        Trainer toDelete = findClass(trainer.getIdTrainer());
        if(toDelete != null) {
            this.trainerDB.remove(toDelete);
            return create(trainer);
        }
        return null;
    }


    @Override
    public void delete(String trainerId) {
        Trainer trainer = findClass(trainerId);
        if (trainer != null) this.trainerDB.remove(trainer);
    }


    @Override
    public Set<Trainer> getAll() {
        return this.trainerDB;
    }
}
