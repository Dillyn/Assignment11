package cput.ac.za.services.classes.Impli;

import cput.ac.za.domain.classes.Speed;
import cput.ac.za.repositories.classes.Impli.EnduranceRepositoryImpli;
import cput.ac.za.repositories.classes.Impli.SpeedRepositoryImpli;
import cput.ac.za.repositories.classes.SpeedRepository;
import cput.ac.za.services.classes.EnduranceService;
import cput.ac.za.services.classes.SpeedService;

import java.util.HashSet;
import java.util.Set;

public class SpeedServiceImpli implements SpeedService {

    private SpeedRepository classRepository;
    private static SpeedService classService = null;

    private SpeedServiceImpli() {
        this.classRepository = SpeedRepositoryImpli.speedRepository();
    }

    public SpeedService getEnduranceService() {
        if (classService == null) classService = new SpeedServiceImpli();
        return classService;
    }

    @Override
    public Speed create(Speed d) {
        return this.classRepository.create(d);
    }

    @Override
    public Speed read(String genderId) {
        return this.classRepository.read(genderId);
    }

    @Override
    public Speed update(Speed gender) {
        return this.classRepository.update(gender);
    }

    @Override
    public void delete(String genderId) {
        this.classRepository.delete(genderId);
    }

    @Override
    public Set<Speed> getAll() {
        return this.classRepository.getAll();
    }
}

