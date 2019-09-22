package cput.ac.za.services.session.impli;

import cput.ac.za.domain.session.Session;
import cput.ac.za.factories.session.SessionFactory;
import cput.ac.za.repositories.session.impli.SessionRepositoryImpli;
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
public class SessionServicesImpliTest {

    private SessionRepositoryImpli repository;
    private Session privateSession;

    private Session getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (SessionRepositoryImpli) SessionRepositoryImpli.sessionRepository();
        this.privateSession = SessionFactory.getSession(new Date());
    }

    @Test
    public void a_create() {
        Session created = this.repository.create(this.privateSession);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateSession);
    }

    @Test
    public void c_update() {
        Date date = new Date();

        Session updated = new Session.Builder().copy(getSaved()).date(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getSessionDate());
    }

    @Test
    public void e_delete() {
        Session saved = getSaved();
        this.repository.delete(saved.getId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Session saved = getSaved();
        Session read = this.repository.read(saved.getId());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Session> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}