package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.Staff;
import cput.ac.za.factories.staff.StaffFactory;
import cput.ac.za.repositories.staff.StaffRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffRepositoryImpliTest {

    private StaffRepository repository;
    private Staff staff;

    private Staff getSavedClass() {
        Set<Staff> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = StaffRepositoryImpli.staffRepository();
        this.staff = StaffFactory.getStaff("1","Dillyn","Lakey","Boss");
    }

    @Test
    public void a_create() {
        Staff created = this.repository.create(this.staff);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.staff);
    }

    @Test
    public void b_read() {
        Staff savedStaff = getSavedClass();
        System.out.println("In read, genderId = "+ savedStaff.getIdStaff());
        Staff read = this.repository.read(savedStaff.getIdStaff());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStaff, read);
    }

    @Test
    public void e_delete() {
        Staff savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdStaff());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Staff staff = new Staff.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + staff);
        Staff updated = this.repository.update(staff);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Staff> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}