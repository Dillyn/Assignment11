package cput.ac.za.repositories.classes.Impli;

import cput.ac.za.domain.classes.Strength;
import cput.ac.za.repositories.classes.StrengthRepository;

import java.util.HashSet;
import java.util.Set;

public class StrengthRepositoryImpli implements StrengthRepository {
    private static StrengthRepository speedRepository = null;
    private Set<Strength> speedDB;

    private StrengthRepositoryImpli() {
        this.speedDB = new HashSet<>();
    }

    private Strength findClass(String classId) {
        return this.speedDB.stream()
                .filter(speed -> speed.getIdClass().trim().equals(classId))
                .findAny()
                .orElse(null);
    }

    public static StrengthRepository strengthRepository() {
        if (speedRepository == null) speedRepository = new StrengthRepositoryImpli();
        return speedRepository;
    }

    @Override
    public Strength create(Strength speed) {
        this.speedDB.add(speed);
        return speed;
    }


    @Override
    public Strength read(String classId) {
        Strength speed = findClass(classId);
        return speed;
    }


    @Override
    public Strength update(Strength speed) {
        Strength toDelete = findClass(speed.getIdClass());
        if(toDelete != null) {
            this.speedDB.remove(toDelete);
            return create(speed);
        }
        return null;
    }


    @Override
    public void delete(String classId) {
        Strength speed = findClass(classId);
        if (speed != null) this.speedDB.remove(speed);
    }


    @Override
    public Set<Strength> getAll() {
        return this.speedDB;
    }
}
