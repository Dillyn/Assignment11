package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.Staff;
import cput.ac.za.repositories.staff.StaffRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("staffRepositoryImpli")
public class StaffRepositoryImpli implements StaffRepository {
    private static StaffRepository staffRepository = null;
    private Set<Staff> staffDB;

    private StaffRepositoryImpli() { this.staffDB = new HashSet<>();
    }

    private Staff findClass(String staffId) {
         Staff staff = this.staffDB.stream()
                .filter(staff1 -> staff1.getIdStaff().trim().equals(staffId))
                .findAny()
                .orElse(null);
        return staff;
    }

    public static StaffRepository staffRepository() {
        if (staffRepository == null) staffRepository = new StaffRepositoryImpli();
        return staffRepository;
    }

    @Override
    public Staff create(Staff staff) {
        this.staffDB.add(staff);
        return staff;
    }


    @Override
    public Staff read(String staffId) {
        Staff staff = findClass(staffId);
        return staff;
    }


    @Override
    public Staff update(Staff staff) {
        Staff toDelete = findClass(staff.getIdStaff());
        if(toDelete != null) {
            this.staffDB.remove(toDelete);
            return create(staff);
        }
        return null;
    }


    @Override
    public void delete(String staffId) {
        Staff staff = findClass(staffId);
        if (staff != null) this.staffDB.remove(staff);
    }


    @Override
    public Set<Staff> getAll() {
        return this.staffDB;
    }
}
