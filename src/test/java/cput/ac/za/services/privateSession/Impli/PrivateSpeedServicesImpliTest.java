package cput.ac.za.services.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateSpeed;
import cput.ac.za.factories.privateSessions.PrivateSpeedFactory;
import cput.ac.za.repositories.privateSession.Impli.PrivateSpeedRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.rmi.MarshalException;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrivateSpeedServicesImpliTest {

    private PrivateSpeedRepositoryImpli repository;
    private PrivateSpeed privateStrength;

    private PrivateSpeed getSaved(){ return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (PrivateSpeedRepositoryImpli) PrivateSpeedRepositoryImpli.sessionRepository();
        this.privateStrength = PrivateSpeedFactory.getPrivateSpeed(new Date(), "Speed");
    }

    @Test
    public void a_create() {
        PrivateSpeed created = this.repository.create(this.privateStrength);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateStrength);
    }

    @Test
    public void c_update() {

        String name = "Speed";

        PrivateSpeed updated = new PrivateSpeed.Builder().copy(getSaved()).type(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getType());
    }

    @Test
    public void e_delete() {
        PrivateSpeed saved = getSaved();
        this.repository.delete(saved.getId());
        d_getAll();
    }

    @Test
    public void b_read() {
        PrivateSpeed saved = getSaved();
        PrivateSpeed read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<PrivateSpeed> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}