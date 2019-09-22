package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.EnduranceTrainer;
import cput.ac.za.repositories.staff.EnduranceTrainerRepository;

import java.util.HashSet;
import java.util.Set;

public class EnduranceTrainerRepositoryImpli implements EnduranceTrainerRepository {
    private static EnduranceTrainerRepository trainerRepository = null;
    private Set<EnduranceTrainer> trainerDB;

    private EnduranceTrainerRepositoryImpli() {
        this.trainerDB = new HashSet<>();
    }

    private EnduranceTrainer findClass(String trainerId) {
        return this.trainerDB.stream()
                .filter(trainer1 -> trainer1.getIdEnduranceTrainer().trim().equals(trainerId))
                .findAny()
                .orElse(null);
    }

    public static EnduranceTrainerRepository enduranceTrainerRepository() {
        if (trainerRepository == null) trainerRepository = new EnduranceTrainerRepositoryImpli();
        return trainerRepository;
    }

    @Override
    public EnduranceTrainer create(EnduranceTrainer trainer) {
        this.trainerDB.add(trainer);
        return trainer;
    }


    @Override
    public EnduranceTrainer read(String trainerId) {
        EnduranceTrainer trainer = findClass(trainerId);
        return trainer;
    }


    @Override
    public EnduranceTrainer update(EnduranceTrainer trainer) {
        EnduranceTrainer toDelete = findClass(trainer.getIdEnduranceTrainer());
        if(toDelete != null) {
            this.trainerDB.remove(toDelete);
            return create(trainer);
        }
        return null;
    }


    @Override
    public void delete(String trainerId) {
        EnduranceTrainer trainer = findClass(trainerId);
        if (trainer != null) this.trainerDB.remove(trainer);
    }


    @Override
    public Set<EnduranceTrainer> getAll() {
        return this.trainerDB;
    }
}
