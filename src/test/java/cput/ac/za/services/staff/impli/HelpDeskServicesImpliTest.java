package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.HelpDesk;
import cput.ac.za.factories.staff.HelpDeskFactory;
import cput.ac.za.repositories.staff.impli.HelpDeskRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HelpDeskServicesImpliTest {

    private HelpDeskRepositoryImpli repository;
    private HelpDesk privateHelpDesk;

    private HelpDesk getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (HelpDeskRepositoryImpli) HelpDeskRepositoryImpli.staffRepository();
        this.privateHelpDesk = HelpDeskFactory.getHelpDesk("Dillyn", "Lakey", "Cheese");
    }

    @Test
    public void a_create() {
        HelpDesk created = this.repository.create(this.privateHelpDesk);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateHelpDesk);
    }

    @Test
    public void c_update() {
        String date = "Mozorella";

        HelpDesk updated = new HelpDesk.Builder().copy(getSaved()).name(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getName());
    }

    @Test
    public void e_delete() {
        HelpDesk saved = getSaved();
        this.repository.delete(saved.getIdHelpDesk());
        d_getAll();
    }

    @Test
    public void b_read() {
        HelpDesk saved = getSaved();
        HelpDesk read = this.repository.read(saved.getIdHelpDesk());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<HelpDesk> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}