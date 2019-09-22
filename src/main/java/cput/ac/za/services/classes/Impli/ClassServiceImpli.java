package cput.ac.za.services.classes.Impli;

import cput.ac.za.domain.classes.Classs;
import cput.ac.za.repositories.classes.ClassRepository;
import cput.ac.za.repositories.classes.Impli.ClassRepositoryImpli;
import cput.ac.za.services.classes.ClassService;

import java.util.HashSet;
import java.util.Set;

public class ClassServiceImpli implements ClassService {

    private ClassRepository classRepository;
    private static ClassService classService = null;

    private ClassServiceImpli() {
        this.classRepository = ClassRepositoryImpli.classRepository();
    }

    public ClassService getClassService() {
        if (classService == null) classService = new ClassServiceImpli();
        return classService;
    }

    @Override
    public Classs create(Classs d) {
        return this.classRepository.create(d);
    }

    @Override
    public Classs read(String genderId) {
        return this.classRepository.read(genderId);
    }

    @Override
    public Classs update(Classs gender) {
        return this.classRepository.update(gender);
    }

    @Override
    public void delete(String genderId) {
        this.classRepository.delete(genderId);
    }

    @Override
    public Set<Classs> getAll() {
        return this.classRepository.getAll();
    }
}

