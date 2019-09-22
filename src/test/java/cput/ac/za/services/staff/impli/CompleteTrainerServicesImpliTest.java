package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.CompleteTrainer;
import cput.ac.za.factories.staff.CompleteTrainerFactory;
import cput.ac.za.repositories.staff.impli.CompleteTrainerRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.rmi.MarshalException;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompleteTrainerServicesImpliTest {

    private CompleteTrainerRepositoryImpli repository;
    private CompleteTrainer privateComplete;

    private CompleteTrainer getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (CompleteTrainerRepositoryImpli) CompleteTrainerRepositoryImpli.trainerRepository();
        this.privateComplete = CompleteTrainerFactory.getCompleteTrainer("Dillyn", "Lakey", "Cheese");
    }

    @Test
    public void a_create() {
        CompleteTrainer created = this.repository.create(this.privateComplete);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateComplete);
    }

    @Test
    public void c_update() {
        String date = "Mozorella";

        CompleteTrainer updated = new CompleteTrainer.Builder().copy(getSaved()).name(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getName());
    }

    @Test
    public void e_delete() {
        CompleteTrainer saved = getSaved();
        this.repository.delete(saved.getIdCompleteTrainer());
        d_getAll();
    }

    @Test
    public void b_read() {
        CompleteTrainer saved = getSaved();
        CompleteTrainer read = this.repository.read(saved.getIdCompleteTrainer());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<CompleteTrainer> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}