package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.HelpDesk;
import cput.ac.za.repositories.staff.HelpDeskRepository;

import java.util.HashSet;
import java.util.Set;

public class HelpDeskRepositoryImpli implements HelpDeskRepository {
    private static HelpDeskRepository staffRepository = null;
    private Set<HelpDesk> staffDB;

    private HelpDeskRepositoryImpli() { this.staffDB = new HashSet<>();
    }

    private HelpDesk findClass(String staffId) {
        return this.staffDB.stream()
                .filter(staff -> staff.getIdHelpDesk().trim().equals(staffId))
                .findAny()
                .orElse(null);
    }

    public static HelpDeskRepository staffRepository() {
        if (staffRepository == null) staffRepository = new HelpDeskRepositoryImpli();
        return staffRepository;
    }

    @Override
    public HelpDesk create(HelpDesk staff) {
        this.staffDB.add(staff);
        return staff;
    }


    @Override
    public HelpDesk read(String staffId) {
        HelpDesk staff = findClass(staffId);
        return staff;
    }


    @Override
    public HelpDesk update(HelpDesk staff) {
        HelpDesk toDelete = findClass(staff.getIdHelpDesk());
        if(toDelete != null) {
            this.staffDB.remove(toDelete);
            return create(staff);
        }
        return null;
    }


    @Override
    public void delete(String staffId) {
        HelpDesk staff = findClass(staffId);
        if (staff != null) this.staffDB.remove(staff);
    }


    @Override
    public Set<HelpDesk> getAll() {
        return this.staffDB;
    }
}
