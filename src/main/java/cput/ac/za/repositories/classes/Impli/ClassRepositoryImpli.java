package cput.ac.za.repositories.classes.Impli;

import cput.ac.za.domain.classes.Classs;
import cput.ac.za.repositories.classes.ClassRepository;

import java.util.HashSet;
import java.util.Set;

public class ClassRepositoryImpli implements ClassRepository {

    private static ClassRepository classRepository = null;
    private Set<Classs> classDB;

    private ClassRepositoryImpli() {
        this.classDB = new HashSet<>();
    }

    private Classs findClass(String classId) {
        return this.classDB.stream()
                .filter(classs -> classs.getIdClass().trim().equals(classId))
                .findAny()
                .orElse(null);
    }

    public static ClassRepository classRepository() {
        if (classRepository == null) classRepository = new ClassRepositoryImpli();
        return classRepository;
    }

    @Override
    public Classs create(Classs classs) {
        this.classDB.add(classs);
        return classs;
    }


    @Override
    public Classs read(String classId) {
        Classs classs = findClass(classId);
        return classs;
    }


    @Override
    public Classs update(Classs classs) {
        Classs toDelete = findClass(classs.getIdClass());
        if(toDelete != null) {
            this.classDB.remove(toDelete);
            return create(classs);
        }
        return null;
    }


    @Override
    public void delete(String classId) {
        Classs classs = findClass(classId);
        if (classs != null) this.classDB.remove(classs);
    }


    @Override
    public Set<Classs> getAll() {
        return this.classDB;
    }
}

