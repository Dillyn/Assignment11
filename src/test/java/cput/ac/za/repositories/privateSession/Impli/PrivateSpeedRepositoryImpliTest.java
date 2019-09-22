package cput.ac.za.repositories.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateSpeed;
import cput.ac.za.factories.privateSessions.PrivateSpeedFactory;
import cput.ac.za.repositories.privateSession.PrivateSpeedRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrivateSpeedRepositoryImpliTest {

    private PrivateSpeedRepository repository;
    private PrivateSpeed privateSpeed;

    private PrivateSpeed getSavedClass() {
        Set<PrivateSpeed> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = PrivateSpeedRepositoryImpli.sessionRepository();
        this.privateSpeed = PrivateSpeedFactory.getPrivateSpeed(new Date(), "Speed");
    }

    @Test
    public void a_create() {
        PrivateSpeed created = this.repository.create(this.privateSpeed);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.privateSpeed);
    }

    @Test
    public void b_read() {
        PrivateSpeed savedPrivateSpeed = getSavedClass();
        System.out.println("In read, genderId = "+ savedPrivateSpeed.getId());
        PrivateSpeed read = this.repository.read(savedPrivateSpeed.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedPrivateSpeed, read);
    }

    @Test
    public void e_delete() {
        PrivateSpeed savedGender = getSavedClass();
        this.repository.delete(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive Speed";
        PrivateSpeed privateSpeed = new PrivateSpeed.Builder().copy(getSavedClass()).type(newName).build();
        System.out.println("In update, about_to_updated = " + privateSpeed);
        PrivateSpeed updated = this.repository.update(privateSpeed);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<PrivateSpeed> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}