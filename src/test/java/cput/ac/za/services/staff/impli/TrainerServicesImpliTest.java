package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.Trainer;
import cput.ac.za.factories.staff.TrainerFactory;
import cput.ac.za.repositories.staff.impli.TrainerRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainerServicesImpliTest {

    private TrainerRepositoryImpli repository;
    private Trainer privateTrainer;

    private Trainer getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (TrainerRepositoryImpli) TrainerRepositoryImpli.trainerRepository();
        this.privateTrainer = TrainerFactory.getTrainer("Dillyn", "Lakey", "Cheese");
    }

    @Test
    public void a_create() {
        Trainer created = this.repository.create(this.privateTrainer);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateTrainer);
    }

    @Test
    public void c_update() {
        String date = "Mozorella";

        Trainer updated = new Trainer.Builder().copy(getSaved()).name(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getName());
    }

    @Test
    public void e_delete() {
        Trainer saved = getSaved();
        this.repository.delete(saved.getIdTrainer());
        d_getAll();
    }

    @Test
    public void b_read() {
        Trainer saved = getSaved();
        Trainer read = this.repository.read(saved.getIdTrainer());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Trainer> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}