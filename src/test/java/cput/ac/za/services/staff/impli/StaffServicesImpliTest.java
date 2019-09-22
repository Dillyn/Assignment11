package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.Staff;
import cput.ac.za.factories.staff.StaffFactory;
import cput.ac.za.repositories.staff.impli.StaffRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffServicesImpliTest {

    private StaffRepositoryImpli repository;
    private Staff privateStaff;

    private Staff getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (StaffRepositoryImpli) StaffRepositoryImpli.staffRepository();
        this.privateStaff = StaffFactory.getStaff("1","Dillyn", "Lakey", "Cheese");
    }

    @Test
    public void a_create() {
        Staff created = this.repository.create(this.privateStaff);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateStaff);
    }

    @Test
    public void c_update() {
        String date = "Mozorella";

        Staff updated = new Staff.Builder().copy(getSaved()).name(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getName());
    }

    @Test
    public void e_delete() {
        Staff saved = getSaved();
        this.repository.delete(saved.getIdStaff());
        d_getAll();
    }

    @Test
    public void b_read() {
        Staff saved = getSaved();
        Staff read = this.repository.read(saved.getIdStaff());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Staff> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}