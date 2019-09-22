package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.SpeedTrainer;
import cput.ac.za.factories.staff.SpeedTrainerFactory;
import cput.ac.za.repositories.staff.SpeedTrainerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpeedTrainerRepositoryImpliTest {

    private SpeedTrainerRepository repository;
    private SpeedTrainer speedTrainer;

    private SpeedTrainer getSavedClass() {
        Set<SpeedTrainer> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = SpeedTrainerRepositoryImpli.speedTrainerRepository();
        this.speedTrainer = SpeedTrainerFactory.getSpeedTrainer("Dillyn","Lakey","Boss");
    }

    @Test
    public void a_create() {
        SpeedTrainer created = this.repository.create(this.speedTrainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.speedTrainer);
    }

    @Test
    public void b_read() {
        SpeedTrainer savedSpeedTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedSpeedTrainer.getIdSpeedTrainer());
        SpeedTrainer read = this.repository.read(savedSpeedTrainer.getIdSpeedTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSpeedTrainer, read);
    }

    @Test
    public void e_delete() {
        SpeedTrainer savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdSpeedTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        SpeedTrainer speedTrainer = new SpeedTrainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + speedTrainer);
        SpeedTrainer updated = this.repository.update(speedTrainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<SpeedTrainer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}