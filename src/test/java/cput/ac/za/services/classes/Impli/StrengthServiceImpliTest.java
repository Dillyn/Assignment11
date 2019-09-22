package cput.ac.za.services.classes.Impli;

import cput.ac.za.domain.classes.Strength;
import cput.ac.za.factories.classes.StrengthClassFactory;
import cput.ac.za.repositories.classes.Impli.StrengthRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StrengthServiceImpliTest {

    private StrengthRepositoryImpli repository;
    private Strength strength;

    private Strength getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (StrengthRepositoryImpli) StrengthRepositoryImpli.strengthRepository();
        this.strength = StrengthClassFactory.getClasss("Dillyn");
    }

    @Test
    public void a_create() {
        Strength created = this.repository.create(this.strength);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.strength);
    }

    @Test
    public void c_update() {

        String name = "class";

        Strength updated = new Strength.Builder().copy(getSaved()).name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void e_delete() {
        Strength saved = getSaved();
        this.repository.delete(saved.getIdClass());
        d_getAll();
    }

    @Test
    public void b_read() {
        Strength saved = getSaved();
        Strength read = this.repository.read(saved.getIdClass());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Strength> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}