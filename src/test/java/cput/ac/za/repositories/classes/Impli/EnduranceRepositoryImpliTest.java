package cput.ac.za.repositories.classes.Impli;

import cput.ac.za.domain.classes.Endurance;
import cput.ac.za.factories.classes.EnduranceClassFactory;
import cput.ac.za.repositories.classes.EnduranceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EnduranceRepositoryImpliTest {

    private EnduranceRepository repository;
    private Endurance endurance;

    private Endurance getSavedClass() {
        Set<Endurance> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EnduranceRepositoryImpli.enduranceRepository();
        this.endurance = EnduranceClassFactory.getClasss("Spinning");
    }

    @Test
    public void a_create() {
        Endurance created = this.repository.create(this.endurance);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.endurance);
    }

    @Test
    public void b_read() {
        Endurance savedEndurance = getSavedClass();
        System.out.println("In read, genderId = "+ savedEndurance.getIdClass());
        Endurance read = this.repository.read(savedEndurance.getIdClass());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedEndurance, read);
    }

    @Test
    public void e_delete() {
        Endurance savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdClass());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Endurance endurance = new Endurance.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + endurance);
        Endurance updated = this.repository.update(endurance);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Endurance> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}