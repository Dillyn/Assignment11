package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.CompleteTrainer;
import cput.ac.za.repositories.staff.CompleteTrainerRepository;
import cput.ac.za.repositories.staff.impli.CompleteTrainerRepositoryImpli;
import cput.ac.za.services.staff.CompleteTrainerServices;

import java.util.HashSet;
import java.util.Set;

public class CompleteTrainerServicesImpli implements CompleteTrainerServices {


        private CompleteTrainerRepository trainerRepository;
        private static CompleteTrainerServices trainerService = null;

    private CompleteTrainerServicesImpli() {
        this.trainerRepository = CompleteTrainerRepositoryImpli.trainerRepository();
    }

        public CompleteTrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new CompleteTrainerServicesImpli();
        return trainerService;
    }

        @Override
        public CompleteTrainer create(CompleteTrainer d) {
        return this.trainerRepository.create(d);
    }

        @Override
        public CompleteTrainer read(String trainerId) {
        return this.trainerRepository.read(trainerId);
    }

        @Override
        public CompleteTrainer update(CompleteTrainer trainer) {
        return this.trainerRepository.update(trainer);
    }

        @Override
        public void delete(String trainerId) {
        this.trainerRepository.delete(trainerId);
    }

        @Override
        public Set<CompleteTrainer> getAll() { return this.trainerRepository.getAll();
    }
    }
