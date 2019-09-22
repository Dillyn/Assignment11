package cput.ac.za.repositories.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateEndurance;
import cput.ac.za.repositories.privateSession.PrivateEnduranceRepository;

import java.util.HashSet;
import java.util.Set;

public class PrivateEnduranceRepositoryImpli implements PrivateEnduranceRepository {

    private static PrivateEnduranceRepository sessionRepository = null;
    private Set<PrivateEndurance> sessionDB;

    private PrivateEnduranceRepositoryImpli() {
        this.sessionDB = new HashSet<>();
    }

    private PrivateEndurance findClass(String session) {
        return this.sessionDB.stream()
                .filter(classs -> classs.getId().trim().equals(session))
                .findAny()
                .orElse(null);
    }

    public static PrivateEnduranceRepository sessionRepository() {
        if (sessionRepository == null) sessionRepository = new PrivateEnduranceRepositoryImpli();
        return sessionRepository;
    }

    @Override
    public PrivateEndurance create(PrivateEndurance session) {
        this.sessionDB.add(session);
        return session;
    }


    @Override
    public PrivateEndurance read(String sessionId) {
        PrivateEndurance session = findClass(sessionId);
        return session;
    }


    @Override
    public PrivateEndurance update(PrivateEndurance privateEndurance) {
        PrivateEndurance toDelete = findClass(privateEndurance.getId());
        if(toDelete != null) {
            this.sessionDB.remove(toDelete);
            return create(privateEndurance);
        }
        return null;
    }


    @Override
    public void delete(String sessionId) {
        PrivateEndurance session = findClass(sessionId);
        if (session != null) this.sessionDB.remove(session);
    }


    @Override
    public Set<PrivateEndurance> getAll() {
        return this.sessionDB;
    }
}
