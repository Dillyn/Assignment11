package cput.ac.za.repositories.classes.Impli;

import cput.ac.za.domain.classes.Speed;
import cput.ac.za.repositories.classes.SpeedRepository;

import java.util.HashSet;
import java.util.Set;

public class SpeedRepositoryImpli implements SpeedRepository {
    private static SpeedRepository speedRepository = null;
    private Set<Speed> speedDB;

    private SpeedRepositoryImpli() {
        this.speedDB = new HashSet<>();
    }

    private Speed findClass(String classId) {
        return this.speedDB.stream()
                .filter(speed -> speed.getIdClass().trim().equals(classId))
                .findAny()
                .orElse(null);
    }

    public static SpeedRepository speedRepository() {
        if (speedRepository == null) speedRepository = new SpeedRepositoryImpli();
        return speedRepository;
    }

    @Override
    public Speed create(Speed speed) {
        this.speedDB.add(speed);
        return speed;
    }


    @Override
    public Speed read(String classId) {
        Speed speed = findClass(classId);
        return speed;
    }


    @Override
    public Speed update(Speed speed) {
        Speed toDelete = findClass(speed.getIdClass());
        if(toDelete != null) {
            this.speedDB.remove(toDelete);
            return create(speed);
        }
        return null;
    }


    @Override
    public void delete(String classId) {
        Speed speed = findClass(classId);
        if (speed != null) this.speedDB.remove(speed);
    }


    @Override
    public Set<Speed> getAll() {
        return this.speedDB;
    }
}
