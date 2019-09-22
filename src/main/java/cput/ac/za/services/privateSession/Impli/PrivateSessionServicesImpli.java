package cput.ac.za.services.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateSession;
import cput.ac.za.repositories.privateSession.Impli.PrivateSessionRepositoryImpli;
import cput.ac.za.repositories.privateSession.Impli.PrivateSpeedRepositoryImpli;
import cput.ac.za.repositories.privateSession.PrivateSessionRepository;
import cput.ac.za.services.privateSession.PrivateSessionServices;

import java.util.HashSet;
import java.util.Set;

public class PrivateSessionServicesImpli implements PrivateSessionServices {

    private PrivateSessionRepository sessionRepository;
    private static PrivateSessionServices sessionService = null;

    private PrivateSessionServicesImpli() {
        this.sessionRepository = PrivateSessionRepositoryImpli.sessionRepository();
    }

    public PrivateSessionServices getPrivateSessionService() {
        if (sessionService == null) sessionService = new PrivateSessionServicesImpli();
        return sessionService;
    }

    @Override
    public PrivateSession create(PrivateSession d) {
        return this.sessionRepository.create(d);
    }

    @Override
    public PrivateSession read(String strengthId) {
        return this.sessionRepository.read(strengthId);
    }

    @Override
    public PrivateSession update(PrivateSession strength) {
        return this.sessionRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.sessionRepository.delete(strengthId);
    }

    @Override
    public Set<PrivateSession> getAll() { return this.sessionRepository.getAll();
    }
}
