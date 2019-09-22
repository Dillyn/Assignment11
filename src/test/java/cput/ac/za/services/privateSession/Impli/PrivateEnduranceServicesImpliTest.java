package cput.ac.za.services.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateEndurance;
import cput.ac.za.factories.privateSessions.PrivateEnduranceFactory;
import cput.ac.za.repositories.privateSession.Impli.PrivateEnduranceRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PrivateEnduranceServicesImpliTest {

    private PrivateEnduranceRepositoryImpli repository;
    private PrivateEndurance privateStrength;

    private PrivateEndurance getSaved(){ return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (PrivateEnduranceRepositoryImpli) PrivateEnduranceRepositoryImpli.sessionRepository();
        this.privateStrength = PrivateEnduranceFactory.getPrivateEndurance(new Date(), "Endurance");
    }

    @Test
    public void a_create() {
        PrivateEndurance created = this.repository.create(this.privateStrength);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateStrength);
    }

    @Test
    public void c_update() {

        String name = "Endurance";

        PrivateEndurance updated = new PrivateEndurance.Builder().copy(getSaved()).type(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getType());
    }

    @Test
    public void e_delete() {
        PrivateEndurance saved = getSaved();
        this.repository.delete(saved.getId());
        d_getAll();
    }

    @Test
    public void b_read() {
        PrivateEndurance saved = getSaved();
        PrivateEndurance read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<PrivateEndurance> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}