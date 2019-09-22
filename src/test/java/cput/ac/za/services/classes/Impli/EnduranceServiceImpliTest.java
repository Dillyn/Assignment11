package cput.ac.za.services.classes.Impli;

import cput.ac.za.domain.classes.Endurance;
import cput.ac.za.factories.classes.EnduranceClassFactory;
import cput.ac.za.factories.staff.EnduranceTrainerFactory;
import cput.ac.za.repositories.classes.Impli.EnduranceRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnduranceServiceImpliTest {

    private EnduranceRepositoryImpli repository;
    private Endurance endurance;

    private Endurance getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (EnduranceRepositoryImpli) EnduranceRepositoryImpli.enduranceRepository();
        this.endurance = EnduranceClassFactory.getClasss("Dillyn");
    }

    @Test
    public void a_create() {
        Endurance created = this.repository.create(this.endurance);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.endurance);
    }

    @Test
    public void c_update() {

        String name = "class";

        Endurance updated = new Endurance.Builder().copy(getSaved()).name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void e_delete() {
        Endurance saved = getSaved();
        this.repository.delete(saved.getIdClass());
        d_getAll();
    }

    @Test
    public void b_read() {
        Endurance saved = getSaved();
        Endurance read = this.repository.read(saved.getIdClass());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Endurance> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}