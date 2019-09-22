package cput.ac.za.services.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateSession;
import cput.ac.za.factories.privateSessions.PrivateSessionFactory;
import cput.ac.za.repositories.privateSession.Impli.PrivateSessionRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrivateSessionServicesImpliTest {

    private PrivateSessionRepositoryImpli repository;
    private PrivateSession privateSession;

    private PrivateSession getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (PrivateSessionRepositoryImpli) PrivateSessionRepositoryImpli.sessionRepository();
        this.privateSession = PrivateSessionFactory.getPrivateSession(new Date(), "Strength");
    }

    @Test
    public void a_create() {
        PrivateSession created = this.repository.create(this.privateSession);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateSession);
    }

    @Test
    public void c_update() {

        String name = "Speed";

        PrivateSession updated = new PrivateSession.Builder().copy(getSaved()).type(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getType());
    }

    @Test
    public void e_delete() {
        PrivateSession saved = getSaved();
        this.repository.delete(saved.getId());
        d_getAll();
    }

    @Test
    public void b_read() {
        PrivateSession saved = getSaved();
        PrivateSession read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<PrivateSession> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}