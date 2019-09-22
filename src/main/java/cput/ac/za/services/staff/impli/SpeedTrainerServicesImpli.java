package cput.ac.za.services.staff.impli;



import cput.ac.za.domain.staff.SpeedTrainer;
import cput.ac.za.repositories.staff.SpeedTrainerRepository;
import cput.ac.za.repositories.staff.impli.SpeedTrainerRepositoryImpli;
import cput.ac.za.services.staff.SpeedTrainerServices;

import java.util.HashSet;
import java.util.Set;

public class SpeedTrainerServicesImpli implements SpeedTrainerServices {

    private SpeedTrainerRepository trainerRepository;
    private static SpeedTrainerServices trainerService = null;

    private SpeedTrainerServicesImpli() {
        this.trainerRepository = SpeedTrainerRepositoryImpli.speedTrainerRepository();
    }

    public SpeedTrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new SpeedTrainerServicesImpli();
        return trainerService;
    }

    @Override
    public SpeedTrainer create(SpeedTrainer d) {
        return this.trainerRepository.create(d);
    }

    @Override
    public SpeedTrainer read(String trainerId) {
        return this.trainerRepository.read(trainerId);
    }

    @Override
    public SpeedTrainer update(SpeedTrainer trainer) {
        return this.trainerRepository.update(trainer);
    }

    @Override
    public void delete(String trainerId) {
        this.trainerRepository.delete(trainerId);
    }

    @Override
    public Set<SpeedTrainer> getAll() { return this.trainerRepository.getAll();
    }
}
