package cput.ac.za.repositories.classes.Impli;

import cput.ac.za.domain.classes.Strength;
import cput.ac.za.factories.classes.StrengthClassFactory;
import cput.ac.za.repositories.classes.StrengthRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StrengthRepositoryImpliTest {

    private StrengthRepository repository;
    private Strength strength;

    private Strength getSavedClass() {
        Set<Strength> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StrengthRepositoryImpli.strengthRepository();
        this.strength = StrengthClassFactory.getClasss("Sprint");
    }

    @Test
    public void a_create() {
        Strength created = this.repository.create(this.strength);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.strength);
    }

    @Test
    public void b_read() {
        Strength savedStrength = getSavedClass();
        System.out.println("In read, genderId = "+ savedStrength.getIdClass());
        Strength read = this.repository.read(savedStrength.getIdClass());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStrength, read);
    }

    @Test
    public void e_delete() {
        Strength savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdClass());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Strength Strength = new Strength.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + Strength);
        Strength updated = this.repository.update(Strength);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Strength> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}