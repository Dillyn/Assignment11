package cput.ac.za.repositories.session.impli;

import cput.ac.za.domain.session.Session;
import cput.ac.za.repositories.session.SessionRepository;

import java.util.HashSet;
import java.util.Set;

public class SessionRepositoryImpli implements SessionRepository {
    private static SessionRepository sessionRepository = null;
    private Set<Session> sessionDB;

    private SessionRepositoryImpli() {
        this.sessionDB = new HashSet<>();
    }

    private Session findClass(String session) {
        return this.sessionDB.stream()
                .filter(classs -> classs.getId().trim().equals(session))
                .findAny()
                .orElse(null);
    }

    public static SessionRepository sessionRepository() {
        if (sessionRepository == null) sessionRepository = new SessionRepositoryImpli();
        return sessionRepository;
    }

    @Override
    public Session create(Session session) {
        this.sessionDB.add(session);
        return session;
    }


    @Override
    public Session read(String sessionId) {
        Session session = findClass(sessionId);
        return session;
    }


    @Override
    public Session update(Session session) {
        Session toDelete = findClass(session.getId());
        if(toDelete != null) {
            this.sessionDB.remove(toDelete);
            return create(session);
        }
        return null;
    }


    @Override
    public void delete(String sessionId) {
        Session session = findClass(sessionId);
        if (session != null) this.sessionDB.remove(session);
    }


    @Override
    public Set<Session> getAll() {
        return this.sessionDB;
    }
}
