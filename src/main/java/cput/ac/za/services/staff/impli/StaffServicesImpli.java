package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.Staff;
import cput.ac.za.repositories.staff.StaffRepository;
import cput.ac.za.repositories.staff.impli.StaffRepositoryImpli;
import cput.ac.za.services.staff.StaffServices;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class StaffServicesImpli implements StaffServices {

    private StaffRepository staffRepository;
    private static StaffServices staffService = null;

    private StaffServicesImpli() {
        this.staffRepository = StaffRepositoryImpli.staffRepository();
    }

    public StaffServices getStaffService() {
        if (staffService == null) staffService = new StaffServicesImpli();
        return staffService;
    }

    @Override
    public Staff create(Staff d) {
        return this.staffRepository.create(d);
    }

    @Override
    public Staff read(String staffId) {
        return this.staffRepository.read(staffId);
    }

    @Override
    public Staff update(Staff staff) {
        return this.staffRepository.update(staff);
    }

    @Override
    public void delete(String staffId) {
        this.staffRepository.delete(staffId);
    }

    @Override
    public Set<Staff> getAll() { return this.staffRepository.getAll();
    }
}
