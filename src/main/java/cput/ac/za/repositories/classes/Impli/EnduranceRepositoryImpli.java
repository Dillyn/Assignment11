package cput.ac.za.repositories.classes.Impli;

import cput.ac.za.domain.classes.Endurance;
import cput.ac.za.repositories.classes.EnduranceRepository;

import java.util.HashSet;
import java.util.Set;

public class EnduranceRepositoryImpli implements EnduranceRepository {
    private static EnduranceRepository enduranceRepository = null;
    private Set<Endurance> enduranceDB;

    private EnduranceRepositoryImpli() {
        this.enduranceDB = new HashSet<>();
    }

    private Endurance findClass(String classId) {
        return this.enduranceDB.stream()
                .filter(endurance -> endurance.getIdClass().trim().equals(classId))
                .findAny()
                .orElse(null);
    }

    public static EnduranceRepository enduranceRepository() {
        if (enduranceRepository == null) enduranceRepository = new EnduranceRepositoryImpli();
        return enduranceRepository;
    }

    @Override
    public Endurance create(Endurance endurance) {
        this.enduranceDB.add(endurance);
        return endurance;
    }


    @Override
    public Endurance read(String classId) {
        Endurance endurance = findClass(classId);
        return endurance;
    }


    @Override
    public Endurance update(Endurance endurance) {
        Endurance toDelete = findClass(endurance.getIdClass());
        if(toDelete != null) {
            this.enduranceDB.remove(toDelete);
            return create(endurance);
        }
        return null;
    }


    @Override
    public void delete(String classId) {
        Endurance endurance = findClass(classId);
        if (endurance != null) this.enduranceDB.remove(endurance);
    }


    @Override
    public Set<Endurance> getAll() {
        return this.enduranceDB;
    }
}
