package cput.ac.za.repositories.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateSession;
import cput.ac.za.repositories.privateSession.PrivateSessionRepository;

import java.util.HashSet;
import java.util.Set;

public class PrivateSessionRepositoryImpli implements PrivateSessionRepository {

    private static PrivateSessionRepository sessionRepository = null;
    private Set<PrivateSession> sessionDB;

    private PrivateSessionRepositoryImpli() {
        this.sessionDB = new HashSet<>();
    }

    private PrivateSession findClass(String session) {
        return this.sessionDB.stream()
                .filter(classs -> classs.getId().trim().equals(session))
                .findAny()
                .orElse(null);
    }

    public static PrivateSessionRepository sessionRepository() {
        if (sessionRepository == null) sessionRepository = new PrivateSessionRepositoryImpli();
        return sessionRepository;
    }

    @Override
    public PrivateSession create(PrivateSession classs) {
        this.sessionDB.add(classs);
        return classs;
    }


    @Override
    public PrivateSession read(String sessionId) {
        PrivateSession session = findClass(sessionId);
        return session;
    }


    @Override
    public PrivateSession update(PrivateSession privateSession) {
        PrivateSession toDelete = findClass(privateSession.getId());
        if(toDelete != null) {
            this.sessionDB.remove(toDelete);
            return create(privateSession);
        }
        return null;
    }


    @Override
    public void delete(String sessionId) {
        PrivateSession session = findClass(sessionId);
        if (session != null) this.sessionDB.remove(session);
    }


    @Override
    public Set<PrivateSession> getAll() {
        return this.sessionDB;
    }
}
