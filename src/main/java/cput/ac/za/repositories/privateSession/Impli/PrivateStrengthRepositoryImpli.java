package cput.ac.za.repositories.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateStrength;
import cput.ac.za.repositories.privateSession.PrivateStrengthRepository;

import java.util.HashSet;
import java.util.Set;

public class PrivateStrengthRepositoryImpli implements PrivateStrengthRepository {

    private static PrivateStrengthRepository sessionRepository = null;
    private Set<PrivateStrength> sessionDB;

    private PrivateStrengthRepositoryImpli() {
        this.sessionDB = new HashSet<>();
    }

    private PrivateStrength findClass(String session) {
        return this.sessionDB.stream()
                .filter(classs -> classs.getId().trim().equals(session))
                .findAny()
                .orElse(null);
    }

    public static PrivateStrengthRepository sessionRepository() {
        if (sessionRepository == null) sessionRepository = new PrivateStrengthRepositoryImpli();
        return sessionRepository;
    }

    @Override
    public PrivateStrength create(PrivateStrength session) {
        this.sessionDB.add(session);
        return session;
    }


    @Override
    public PrivateStrength read(String sessionId) {
        PrivateStrength session = findClass(sessionId);
        return session;
    }


    @Override
    public PrivateStrength update(PrivateStrength privateEndurance) {
        PrivateStrength toDelete = findClass(privateEndurance.getId());
        if(toDelete != null) {
            this.sessionDB.remove(toDelete);
            return create(privateEndurance);
        }
        return null;
    }


    @Override
    public void delete(String sessionId) {
        PrivateStrength session = findClass(sessionId);
        if (session != null) this.sessionDB.remove(session);
    }


    @Override
    public Set<PrivateStrength> getAll() {
        return this.sessionDB;
    }
}