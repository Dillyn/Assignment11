package cput.ac.za.repositories.privateStrength.Impli;

import cput.ac.za.domain.privateSession.PrivateStrength;
import cput.ac.za.factories.privateSessions.PrivateStrengthFactory;
import cput.ac.za.repositories.privateSession.Impli.PrivateStrengthRepositoryImpli;
import cput.ac.za.repositories.privateSession.PrivateStrengthRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrivateStrengthRepositoryImpliTest {

    private PrivateStrengthRepository repository;
    private PrivateStrength privateStrength;

    private PrivateStrength getSavedClass() {
        Set<PrivateStrength> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = PrivateStrengthRepositoryImpli.sessionRepository();
        this.privateStrength = PrivateStrengthFactory.getPrivateStrength(new Date(), "Strength");
    }

    @Test
    public void a_create() {
        PrivateStrength created = this.repository.create(this.privateStrength);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.privateStrength);
    }

    @Test
    public void b_read() {
        PrivateStrength savedPrivateStrength = getSavedClass();
        System.out.println("In read, genderId = "+ savedPrivateStrength.getId());
        PrivateStrength read = this.repository.read(savedPrivateStrength.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedPrivateStrength, read);
    }

    @Test
    public void e_delete() {
        PrivateStrength savedGender = getSavedClass();
        this.repository.delete(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive Strength";
        PrivateStrength privateStrength = new PrivateStrength.Builder().copy(getSavedClass()).type(newName).build();
        System.out.println("In update, about_to_updated = " + privateStrength);
        PrivateStrength updated = this.repository.update(privateStrength);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<PrivateStrength> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}