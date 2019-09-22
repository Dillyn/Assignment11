package cput.ac.za.services.classes.Impli;

import cput.ac.za.domain.classes.Speed;
import cput.ac.za.factories.classes.SpeedClassFactory;
import cput.ac.za.repositories.classes.Impli.SpeedRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.rmi.MarshalException;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpeedServiceImpliTest {

    private SpeedRepositoryImpli repository;
    private Speed speed;

    private Speed getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (SpeedRepositoryImpli) SpeedRepositoryImpli.speedRepository();
        this.speed = SpeedClassFactory.getClasss("Dillyn");
    }

    @Test
    public void a_create() {
        Speed created = this.repository.create(this.speed);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.speed);
    }

    @Test
    public void c_update() {

        String name = "class";

        Speed updated = new Speed.Builder().copy(getSaved()).name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void e_delete() {
        Speed saved = getSaved();
        this.repository.delete(saved.getIdClass());
        d_getAll();
    }

    @Test
    public void b_read() {
        Speed saved = getSaved();
        Speed read = this.repository.read(saved.getIdClass());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Speed> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}