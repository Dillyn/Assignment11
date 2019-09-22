package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.HelpDesk;
import cput.ac.za.factories.staff.HelpDeskFactory;
import cput.ac.za.repositories.staff.HelpDeskRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HelpDeskRepositoryImpliTest {

    private HelpDeskRepository repository;
    private HelpDesk helpDesk;

    private HelpDesk getSavedClass() {
        Set<HelpDesk> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = HelpDeskRepositoryImpli.staffRepository();
        this.helpDesk = HelpDeskFactory.getHelpDesk("Dillyn","Lakey","Boss");
    }

    @Test
    public void a_create() {
        HelpDesk created = this.repository.create(this.helpDesk);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.helpDesk);
    }

    @Test
    public void b_read() {
        HelpDesk savedHelpDesk = getSavedClass();
        System.out.println("In read, genderId = "+ savedHelpDesk.getIdHelpDesk());
        HelpDesk read = this.repository.read(savedHelpDesk.getIdHelpDesk());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedHelpDesk, read);
    }

    @Test
    public void e_delete() {
        HelpDesk savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdHelpDesk());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        HelpDesk helpDesk = new HelpDesk.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + helpDesk);
        HelpDesk updated = this.repository.update(helpDesk);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<HelpDesk> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}