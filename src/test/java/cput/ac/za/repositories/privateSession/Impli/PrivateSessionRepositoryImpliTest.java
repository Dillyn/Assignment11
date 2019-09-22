package cput.ac.za.repositories.privateSession.Impli;

import cput.ac.za.domain.privateSession.PrivateSession;
import cput.ac.za.factories.privateSessions.PrivateSessionFactory;
import cput.ac.za.repositories.privateSession.PrivateSessionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PrivateSessionRepositoryImpliTest  {

    private PrivateSessionRepository repository;
    private PrivateSession privateSession;

    private PrivateSession getSavedClass() {
        Set<PrivateSession> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
    //    Date date = new Date();
        this.repository = PrivateSessionRepositoryImpli.sessionRepository();
        this.privateSession = PrivateSessionFactory.getPrivateSession(new Date(), "Strength");
    }

    @Test
    public void a_create() {
        PrivateSession created = this.repository.create(this.privateSession);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.privateSession);
    }

    @Test
    public void b_read() {
        PrivateSession savedPrivateSession = getSavedClass();
        System.out.println("In read, genderId = "+ savedPrivateSession.getId());
        PrivateSession read = this.repository.read(savedPrivateSession.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedPrivateSession, read);
    }

    @Test
    public void e_delete() {
        PrivateSession savedGender = getSavedClass();
        this.repository.delete(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        PrivateSession privateSession = new PrivateSession.Builder().copy(getSavedClass()).type(newName).build();
        System.out.println("In update, about_to_updated = " + privateSession);
        PrivateSession updated = this.repository.update(privateSession);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<PrivateSession> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}