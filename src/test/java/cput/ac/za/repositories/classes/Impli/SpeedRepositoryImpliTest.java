package cput.ac.za.repositories.classes.Impli;

import cput.ac.za.domain.classes.Speed;
import cput.ac.za.factories.classes.SpeedClassFactory;
import cput.ac.za.repositories.classes.SpeedRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class SpeedRepositoryImpliTest {

    private SpeedRepository repository;
    private Speed speed;

    private Speed getSavedClass() {
        Set<Speed> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SpeedRepositoryImpli.speedRepository();
        this.speed = SpeedClassFactory.getClasss("Sprint");
    }

    @Test
    public void a_create() {
        Speed created = this.repository.create(this.speed);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.speed);
    }

    @Test
    public void b_read() {
        Speed savedSpeed = getSavedClass();
        System.out.println("In read, genderId = "+ savedSpeed.getIdClass());
        Speed read = this.repository.read(savedSpeed.getIdClass());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSpeed, read);
    }

    @Test
    public void e_delete() {
        Speed savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdClass());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Speed Speed = new Speed.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + Speed);
        Speed updated = this.repository.update(Speed);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Speed> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}