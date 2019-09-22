package cput.ac.za.repositories.session.impli;

import cput.ac.za.domain.session.Session;
import cput.ac.za.factories.session.SessionFactory;
import cput.ac.za.repositories.session.SessionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionRepositoryImpliTest {

    private SessionRepository repository;
    private Session session;

    private Session getSavedClass() {
        Set<Session> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = SessionRepositoryImpli.sessionRepository();
        this.session = SessionFactory.getSession(new Date());
    }

    @Test
    public void a_create() {
        Session created = this.repository.create(this.session);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.session);
    }

    @Test
    public void b_read() {
        Session savedSession = getSavedClass();
        System.out.println("In read, genderId = "+ savedSession.getId());
        Session read = this.repository.read(savedSession.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSession, read);
    }

    @Test
    public void e_delete() {
        Session savedGender = getSavedClass();
        this.repository.delete(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        Date newName = new Date();
        Session session = new Session.Builder().copy(getSavedClass()).date(newName).build();
        System.out.println("In update, about_to_updated = " + session);
        Session updated = this.repository.update(session);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getSessionDate());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Session> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}