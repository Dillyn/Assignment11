package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.Manager;
import cput.ac.za.factories.staff.ManagerFactory;
import cput.ac.za.repositories.staff.impli.ManagerRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerServicesImpliTest {

    private ManagerRepositoryImpli repository;
    private Manager privateManager;

    private Manager getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (ManagerRepositoryImpli) ManagerRepositoryImpli.staffRepository();
        this.privateManager = ManagerFactory.getManager("Dillyn", "Lakey", "Cheese");
    }

    @Test
    public void a_create() {
        Manager created = this.repository.create(this.privateManager);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateManager);
    }

    @Test
    public void c_update() {
        String date = "Mozorella";

        Manager updated = new Manager.Builder().copy(getSaved()).name(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getName());
    }

    @Test
    public void e_delete() {
        Manager saved = getSaved();
        this.repository.delete(saved.getIdManager());
        d_getAll();
    }

    @Test
    public void b_read() {
        Manager saved = getSaved();
        Manager read = this.repository.read(saved.getIdManager());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Manager> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}