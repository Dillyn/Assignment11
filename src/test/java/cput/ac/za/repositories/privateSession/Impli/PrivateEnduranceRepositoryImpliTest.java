package cput.ac.za.repositories.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateEndurance;
import cput.ac.za.factories.privateSessions.PrivateEnduranceFactory;
import cput.ac.za.repositories.privateSession.PrivateEnduranceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrivateEnduranceRepositoryImpliTest {

    private PrivateEnduranceRepository repository;
    private PrivateEndurance privateEndurance;

    private PrivateEndurance getSavedClass() {
        Set<PrivateEndurance> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = PrivateEnduranceRepositoryImpli.sessionRepository();
        this.privateEndurance = PrivateEnduranceFactory.getPrivateEndurance(new Date(), "Endurance");
    }

    @Test
    public void a_create() {
        PrivateEndurance created = this.repository.create(this.privateEndurance);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.privateEndurance);
    }

    @Test
    public void b_read() {
        PrivateEndurance savedPrivateEndurance = getSavedClass();
        System.out.println("In read, genderId = "+ savedPrivateEndurance.getId());
        PrivateEndurance read = this.repository.read(savedPrivateEndurance.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedPrivateEndurance, read);
    }

    @Test
    public void e_delete() {
        PrivateEndurance savedGender = getSavedClass();
        this.repository.delete(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive Endurance";
        PrivateEndurance privateEndurance = new PrivateEndurance.Builder().copy(getSavedClass()).type(newName).build();
        System.out.println("In update, about_to_updated = " + privateEndurance);
        PrivateEndurance updated = this.repository.update(privateEndurance);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<PrivateEndurance> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}