package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.Manager;
import cput.ac.za.factories.staff.ManagerFactory;
import cput.ac.za.repositories.staff.ManagerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerRepositoryImpliTest {

    private ManagerRepository repository;
    private Manager manager;

    private Manager getSavedClass() {
        Set<Manager> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = ManagerRepositoryImpli.staffRepository();
        this.manager = ManagerFactory.getManager("Dillyn","Lakey","Boss");
    }

    @Test
    public void a_create() {
        Manager created = this.repository.create(this.manager);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.manager);
    }

    @Test
    public void b_read() {
        Manager savedManager = getSavedClass();
        System.out.println("In read, genderId = "+ savedManager.getIdManager());
        Manager read = this.repository.read(savedManager.getIdManager());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedManager, read);
    }

    @Test
    public void e_delete() {
        Manager savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdManager());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Manager manager = new Manager.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + manager);
        Manager updated = this.repository.update(manager);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Manager> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}