package cput.ac.za.services.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateStrength;
import cput.ac.za.factories.privateSessions.PrivateStrengthFactory;
import cput.ac.za.repositories.privateSession.Impli.PrivateStrengthRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrivateStrengthServicesImpliTest {

    private PrivateStrengthRepositoryImpli repository;
    private PrivateStrength privateStrenght;

    private PrivateStrength getSaved(){ return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (PrivateStrengthRepositoryImpli) PrivateStrengthRepositoryImpli.sessionRepository();
        this.privateStrenght = PrivateStrengthFactory.getPrivateStrength(new Date(), "Strength");
    }

    @Test
    public void a_create() {
        PrivateStrength created = this.repository.create(this.privateStrenght);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateStrenght);
    }

    @Test
    public void c_update() {

        String name = "Speed";

        PrivateStrength updated = new PrivateStrength.Builder().copy(getSaved()).type(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getType());
    }

    @Test
    public void e_delete() {
        PrivateStrength saved = getSaved();
        this.repository.delete(saved.getId());
        d_getAll();
    }

    @Test
    public void b_read() {
        PrivateStrength saved = getSaved();
        PrivateStrength read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<PrivateStrength> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}