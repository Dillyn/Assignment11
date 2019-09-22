package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.EnduranceTrainer;
import cput.ac.za.repositories.staff.EnduranceTrainerRepository;
import cput.ac.za.repositories.staff.impli.EnduranceTrainerRepositoryImpli;
import cput.ac.za.services.staff.EnduranceTrainerServices;

import java.util.HashSet;
import java.util.Set;

public class EnduranceTrainerServicesImpli implements EnduranceTrainerServices {

    private EnduranceTrainerRepository trainerRepository;
    private static EnduranceTrainerServices trainerService = null;

    private EnduranceTrainerServicesImpli() {
        this.trainerRepository = EnduranceTrainerRepositoryImpli.enduranceTrainerRepository();
    }

    public EnduranceTrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new EnduranceTrainerServicesImpli();
        return trainerService;
    }

    @Override
    public EnduranceTrainer create(EnduranceTrainer d) {
        return this.trainerRepository.create(d);
    }

    @Override
    public EnduranceTrainer read(String trainerId) {
        return this.trainerRepository.read(trainerId);
    }

    @Override
    public EnduranceTrainer update(EnduranceTrainer trainer) {
        return this.trainerRepository.update(trainer);
    }

    @Override
    public void delete(String trainerId) {
        this.trainerRepository.delete(trainerId);
    }

    @Override
    public Set<EnduranceTrainer> getAll() { return this.trainerRepository.getAll();
    }
}