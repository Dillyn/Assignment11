package cput.ac.za.services.classes.Impli;

import cput.ac.za.domain.classes.Strength;
import cput.ac.za.repositories.classes.Impli.StrengthRepositoryImpli;
import cput.ac.za.repositories.classes.StrengthRepository;
import cput.ac.za.services.classes.StrengthService;

import java.util.HashSet;
import java.util.Set;

public class StrengthServiceImpli implements StrengthService {

    private StrengthRepository classRepository;
    private static StrengthService classService = null;

    private StrengthServiceImpli() {
        this.classRepository = StrengthRepositoryImpli.strengthRepository();
    }

    public StrengthService getStrengthService() {
        if (classService == null) classService = new StrengthServiceImpli();
        return classService;
    }

    @Override
    public Strength create(Strength d) { return this.classRepository.create(d);
    }

    @Override
    public Strength read(String strengthId) {
        return this.classRepository.read(strengthId);
    }

    @Override
    public Strength update(Strength strength) {
        return this.classRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.classRepository.delete(strengthId);
    }

    @Override
    public Set<Strength> getAll() {
        return this.classRepository.getAll();
    }
}