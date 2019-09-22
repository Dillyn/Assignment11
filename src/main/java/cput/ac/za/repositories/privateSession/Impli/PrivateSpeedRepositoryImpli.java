package cput.ac.za.repositories.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateSpeed;
import cput.ac.za.repositories.privateSession.PrivateSpeedRepository;

import java.util.HashSet;
import java.util.Set;

public class PrivateSpeedRepositoryImpli implements PrivateSpeedRepository {

    private static PrivateSpeedRepository sessionRepository = null;
    private Set<PrivateSpeed> sessionDB;

    private PrivateSpeedRepositoryImpli() {
        this.sessionDB = new HashSet<>();
    }

    private PrivateSpeed findClass(String session) {
        return this.sessionDB.stream()
                .filter(classs -> classs.getId().trim().equals(session))
                .findAny()
                .orElse(null);
    }

    public static PrivateSpeedRepository sessionRepository() {
        if (sessionRepository == null) sessionRepository = new PrivateSpeedRepositoryImpli();
        return sessionRepository;
    }

    @Override
    public PrivateSpeed create(PrivateSpeed session) {
        this.sessionDB.add(session);
        return session;
    }


    @Override
    public PrivateSpeed read(String sessionId) {
        PrivateSpeed session = findClass(sessionId);
        return session;
    }


    @Override
    public PrivateSpeed update(PrivateSpeed privateEndurance) {
        PrivateSpeed toDelete = findClass(privateEndurance.getId());
        if(toDelete != null) {
            this.sessionDB.remove(toDelete);
            return create(privateEndurance);
        }
        return null;
    }


    @Override
    public void delete(String sessionId) {
        PrivateSpeed session = findClass(sessionId);
        if (session != null) this.sessionDB.remove(session);
    }


    @Override
    public Set<PrivateSpeed> getAll() {
        return this.sessionDB;
    }
}
