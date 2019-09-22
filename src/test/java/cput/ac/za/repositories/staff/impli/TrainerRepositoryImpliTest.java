package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.Trainer;
import cput.ac.za.factories.staff.TrainerFactory;
import cput.ac.za.repositories.staff.TrainerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainerRepositoryImpliTest {

    private TrainerRepository repository;
    private Trainer trainer;

    private Trainer getSavedClass() {
        Set<Trainer> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = TrainerRepositoryImpli.trainerRepository();
        this.trainer = TrainerFactory.getTrainer("Dillyn","Lakey","Boss");
    }

    @Test
    public void a_create() {
        Trainer created = this.repository.create(this.trainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.trainer);
    }

    @Test
    public void b_read() {
        Trainer savedTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedTrainer.getIdTrainer());
        Trainer read = this.repository.read(savedTrainer.getIdTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTrainer, read);
    }

    @Test
    public void e_delete() {
        Trainer savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Trainer trainer = new Trainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + trainer);
        Trainer updated = this.repository.update(trainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Trainer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}