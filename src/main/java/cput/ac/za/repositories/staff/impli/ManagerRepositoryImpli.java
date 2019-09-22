package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.Manager;
import cput.ac.za.repositories.staff.ManagerRepository;

import java.util.HashSet;
import java.util.Set;

public class ManagerRepositoryImpli implements ManagerRepository {
    private static ManagerRepository staffRepository = null;
    private Set<Manager> staffDB;

    private ManagerRepositoryImpli() { this.staffDB = new HashSet<>();
    }

    private Manager findClass(String staffId) {
        return this.staffDB.stream()
                .filter(staff -> staff.getIdManager().trim().equals(staffId))
                .findAny()
                .orElse(null);
    }

    public static ManagerRepository staffRepository() {
        if (staffRepository == null) staffRepository = new ManagerRepositoryImpli();
        return staffRepository;
    }

    @Override
    public Manager create(Manager staff) {
        this.staffDB.add(staff);
        return staff;
    }


    @Override
    public Manager read(String staffId) {
        Manager staff = findClass(staffId);
        return staff;
    }


    @Override
    public Manager update(Manager staff) {
        Manager toDelete = findClass(staff.getIdManager());
        if(toDelete != null) {
            this.staffDB.remove(toDelete);
            return create(staff);
        }
        return null;
    }


    @Override
    public void delete(String staffId) {
        Manager staff = findClass(staffId);
        if (staff != null) this.staffDB.remove(staff);
    }


    @Override
    public Set<Manager> getAll() {
        return this.staffDB;
    }
}
