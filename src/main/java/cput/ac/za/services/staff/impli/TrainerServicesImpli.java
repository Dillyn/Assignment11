package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.Trainer;
import cput.ac.za.repositories.staff.TrainerRepository;
import cput.ac.za.repositories.staff.impli.TrainerRepositoryImpli;
import cput.ac.za.services.staff.TrainerServices;

import java.util.HashSet;
import java.util.Set;

public class TrainerServicesImpli implements TrainerServices {

    private TrainerRepository trainerRepository;
    private static TrainerServices trainerService = null;

    private TrainerServicesImpli() {
        this.trainerRepository = TrainerRepositoryImpli.trainerRepository();
    }

    public TrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new TrainerServicesImpli();
        return trainerService;
    }

    @Override
    public Trainer create(Trainer d) {
        return this.trainerRepository.create(d);
    }

    @Override
    public Trainer read(String trainerId) {
        return this.trainerRepository.read(trainerId);
    }

    @Override
    public Trainer update(Trainer trainer) {
        return this.trainerRepository.update(trainer);
    }

    @Override
    public void delete(String trainerId) {
        this.trainerRepository.delete(trainerId);
    }

    @Override
    public Set<Trainer> getAll() { return this.trainerRepository.getAll();
    }
}
