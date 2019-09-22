package cput.ac.za.services.classes.Impli;

import cput.ac.za.domain.classes.Endurance;
import cput.ac.za.repositories.classes.EnduranceRepository;
import cput.ac.za.repositories.classes.Impli.ClassRepositoryImpli;
import cput.ac.za.repositories.classes.Impli.EnduranceRepositoryImpli;
import cput.ac.za.services.classes.ClassService;
import cput.ac.za.services.classes.EnduranceService;

import java.util.HashSet;
import java.util.Set;

public class EnduranceServiceImpli implements EnduranceService {

    private EnduranceRepository classRepository;
    private static EnduranceService classService = null;

    private EnduranceServiceImpli() {
        this.classRepository = EnduranceRepositoryImpli.enduranceRepository();
    }

    public EnduranceService getEnduranceService() {
        if (classService == null) classService = new EnduranceServiceImpli();
        return classService;
    }

    @Override
    public Endurance create(Endurance d) {
        return this.classRepository.create(d);
    }

    @Override
    public Endurance read(String genderId) {
        return this.classRepository.read(genderId);
    }

    @Override
    public Endurance update(Endurance gender) {
        return this.classRepository.update(gender);
    }

    @Override
    public void delete(String genderId) {
        this.classRepository.delete(genderId);
    }

    @Override
    public Set<Endurance> getAll() {
        return this.classRepository.getAll();
    }
}



