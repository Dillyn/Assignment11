package cput.ac.za.services.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateStrength;
import cput.ac.za.repositories.privateSession.Impli.PrivateStrengthRepositoryImpli;
import cput.ac.za.repositories.privateSession.PrivateStrengthRepository;
import cput.ac.za.services.privateSession.PrivateStrengthServices;

import java.util.HashSet;
import java.util.Set;

public class PrivateStrengthServicesImpli implements PrivateStrengthServices {

    private PrivateStrengthRepository sessionRepository;
    private static PrivateStrengthServices sessionService = null;

    private PrivateStrengthServicesImpli() {
        this.sessionRepository = PrivateStrengthRepositoryImpli.sessionRepository();
    }

    public PrivateStrengthServices getPrivateSessionService() {
        if (sessionService == null) sessionService = new PrivateStrengthServicesImpli();
        return sessionService;
    }

    @Override
    public PrivateStrength create(PrivateStrength d) {
        return this.sessionRepository.create(d);
    }

    @Override
    public PrivateStrength read(String strengthId) {
        return this.sessionRepository.read(strengthId);
    }

    @Override
    public PrivateStrength update(PrivateStrength strength) {
        return this.sessionRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.sessionRepository.delete(strengthId);
    }

    @Override
    public Set<PrivateStrength> getAll() { return this.sessionRepository.getAll();
    }
}