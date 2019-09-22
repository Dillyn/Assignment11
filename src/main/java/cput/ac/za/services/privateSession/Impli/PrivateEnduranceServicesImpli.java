package cput.ac.za.services.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateEndurance;
import cput.ac.za.repositories.privateSession.Impli.PrivateEnduranceRepositoryImpli;
import cput.ac.za.repositories.privateSession.PrivateEnduranceRepository;
import cput.ac.za.services.privateSession.PrivateEnduranceServices;

import java.util.HashSet;
import java.util.Set;

public class PrivateEnduranceServicesImpli implements PrivateEnduranceServices {

    private PrivateEnduranceRepository sessionRepository;
    private static PrivateEnduranceServices sessionService = null;

    private PrivateEnduranceServicesImpli() {
        this.sessionRepository = PrivateEnduranceRepositoryImpli.sessionRepository();
    }

    public PrivateEnduranceServices getPrivateSessionService() {
        if (sessionService == null) sessionService = new PrivateEnduranceServicesImpli();
        return sessionService;
    }

    @Override
    public PrivateEndurance create(PrivateEndurance d) {
        return this.sessionRepository.create(d);
    }

    @Override
    public PrivateEndurance read(String strengthId) {
        return this.sessionRepository.read(strengthId);
    }

    @Override
    public PrivateEndurance update(PrivateEndurance strength) {
        return this.sessionRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.sessionRepository.delete(strengthId);
    }

    @Override
    public Set<PrivateEndurance> getAll() { return this.sessionRepository.getAll();
    }
}
