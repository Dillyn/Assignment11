package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.CompleteTrainer;
import cput.ac.za.factories.staff.CompleteTrainerFactory;
import cput.ac.za.repositories.staff.CompleteTrainerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompleteTrainerRepositoryImpliTest {

    private CompleteTrainerRepository repository;
    private CompleteTrainer completeTrainer;

    private CompleteTrainer getSavedClass() {
        Set<CompleteTrainer> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = CompleteTrainerRepositoryImpli.trainerRepository();
        this.completeTrainer = CompleteTrainerFactory.getCompleteTrainer("Dillyn","Lakey","Boss");
    }

    @Test
    public void a_create() {
        CompleteTrainer created = this.repository.create(this.completeTrainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.completeTrainer);
    }

    @Test
    public void b_read() {
        CompleteTrainer savedCompleteTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedCompleteTrainer.getIdCompleteTrainer());
        CompleteTrainer read = this.repository.read(savedCompleteTrainer.getIdCompleteTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedCompleteTrainer, read);
    }

    @Test
    public void e_delete() {
        CompleteTrainer savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdCompleteTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        CompleteTrainer completeTrainer = new CompleteTrainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + completeTrainer);
        CompleteTrainer updated = this.repository.update(completeTrainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<CompleteTrainer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}