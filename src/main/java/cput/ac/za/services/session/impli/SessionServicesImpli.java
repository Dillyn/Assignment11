package cput.ac.za.services.session.impli;

import cput.ac.za.domain.session.Session;
import cput.ac.za.repositories.session.SessionRepository;
import cput.ac.za.repositories.session.impli.SessionRepositoryImpli;
import cput.ac.za.services.session.SessionServices;

import java.util.HashSet;
import java.util.Set;

public class SessionServicesImpli implements SessionServices {

    private SessionRepository sessionRepository;
    private static SessionServices sessionService = null;

    private SessionServicesImpli() {
        this.sessionRepository = SessionRepositoryImpli.sessionRepository();
    }

    public SessionServices getSessionService() {
        if (sessionService == null) sessionService = new SessionServicesImpli();
        return sessionService;
    }

    @Override
    public Session create(Session d) {
        return this.sessionRepository.create(d);
    }

    @Override
    public Session read(String strengthId) {
        return this.sessionRepository.read(strengthId);
    }

    @Override
    public Session update(Session strength) {
        return this.sessionRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.sessionRepository.delete(strengthId);
    }

    @Override
    public Set<Session> getAll() { return this.sessionRepository.getAll();
    }
}
