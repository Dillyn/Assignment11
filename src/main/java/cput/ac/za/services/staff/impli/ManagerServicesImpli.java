package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.Manager;
import cput.ac.za.domain.staff.Manager;
import cput.ac.za.repositories.staff.ManagerRepository;
import cput.ac.za.repositories.staff.StaffRepository;
import cput.ac.za.repositories.staff.impli.ManagerRepositoryImpli;
import cput.ac.za.services.staff.ManagerServices;
import cput.ac.za.services.staff.ManagerServices;

import java.util.HashSet;
import java.util.Set;

public class ManagerServicesImpli implements ManagerServices {

    private ManagerRepository staffRepository;
    private static ManagerServices staffService = null;

    private ManagerServicesImpli() {
        this.staffRepository = ManagerRepositoryImpli.staffRepository();
    }

    public ManagerServices getsManagerService() {
        if (staffService == null) staffService = new ManagerServicesImpli();
        return staffService;
    }

    @Override
    public Manager create(Manager d) {
        return this.staffRepository.create(d);
    }

    @Override
    public Manager read(String staffId) {
        return this.staffRepository.read(staffId);
    }

    @Override
    public Manager update(Manager manager) {
        return this.staffRepository.update(manager);
    }

    @Override
    public void delete(String staffId) {
        this.staffRepository.delete(staffId);
    }

    @Override
    public Set<Manager> getAll() { return this.staffRepository.getAll();
    }
}
