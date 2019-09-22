package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.StrengthTrainer;
import cput.ac.za.repositories.staff.StrengthTrainerRepository;
import cput.ac.za.repositories.staff.impli.StrengthTrainerRepositoryImpli;
import cput.ac.za.services.staff.StrengthTrainerServices;

import java.util.HashSet;
import java.util.Set;

public class StrengthTrainerServicesImpli implements StrengthTrainerServices {

    private StrengthTrainerRepository trainerRepository;
    private static StrengthTrainerServices trainerService = null;

    private StrengthTrainerServicesImpli() {
        this.trainerRepository = StrengthTrainerRepositoryImpli.strengthTrainerRepository();
    }

    public StrengthTrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new StrengthTrainerServicesImpli();
        return trainerService;
    }

    @Override
    public StrengthTrainer create(StrengthTrainer d) {
        return this.trainerRepository.create(d);
    }

    @Override
    public StrengthTrainer read(String trainerId) {
        return this.trainerRepository.read(trainerId);
    }

    @Override
    public StrengthTrainer update(StrengthTrainer trainer) {
        return this.trainerRepository.update(trainer);
    }

    @Override
    public void delete(String trainerId) {
        this.trainerRepository.delete(trainerId);
    }

    @Override
    public Set<StrengthTrainer> getAll() { return this.trainerRepository.getAll();
    }
}
