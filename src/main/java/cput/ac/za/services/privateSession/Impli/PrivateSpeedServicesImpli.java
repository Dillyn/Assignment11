package cput.ac.za.services.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateSpeed;
import cput.ac.za.repositories.privateSession.Impli.PrivateSpeedRepositoryImpli;
import cput.ac.za.repositories.privateSession.PrivateSpeedRepository;
import cput.ac.za.services.privateSession.PrivateSpeedServices;

import java.util.HashSet;
import java.util.Set;

public class PrivateSpeedServicesImpli implements PrivateSpeedServices {

    private PrivateSpeedRepository sessionRepository;
    private static PrivateSpeedServices sessionService = null;

    private PrivateSpeedServicesImpli() {
        this.sessionRepository = PrivateSpeedRepositoryImpli.sessionRepository();
    }

    public PrivateSpeedServices getPrivateSessionService() {
        if (sessionService == null) sessionService = new PrivateSpeedServicesImpli();
        return sessionService;
    }

    @Override
    public PrivateSpeed create(PrivateSpeed d) {
        return this.sessionRepository.create(d);
    }

    @Override
    public PrivateSpeed read(String strengthId) {
        return this.sessionRepository.read(strengthId);
    }

    @Override
    public PrivateSpeed update(PrivateSpeed strength) {
        return this.sessionRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.sessionRepository.delete(strengthId);
    }

    @Override
    public Set<PrivateSpeed> getAll() { return this.sessionRepository.getAll();
    }
}
