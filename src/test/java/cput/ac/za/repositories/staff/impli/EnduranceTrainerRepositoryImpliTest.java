package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.EnduranceTrainer;
import cput.ac.za.factories.staff.EnduranceTrainerFactory;
import cput.ac.za.repositories.staff.EnduranceTrainerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnduranceTrainerRepositoryImpliTest {

    private EnduranceTrainerRepository repository;
    private EnduranceTrainer enduranceTrainer;

    private EnduranceTrainer getSavedClass() {
        Set<EnduranceTrainer> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = EnduranceTrainerRepositoryImpli.enduranceTrainerRepository();
        this.enduranceTrainer = EnduranceTrainerFactory.getEnduranceTrainer("Dillyn","Lakey","Boss");
    }

    @Test
    public void a_create() {
        EnduranceTrainer created = this.repository.create(this.enduranceTrainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.enduranceTrainer);
    }

    @Test
    public void b_read() {
        EnduranceTrainer savedEnduranceTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedEnduranceTrainer.getIdEnduranceTrainer());
        EnduranceTrainer read = this.repository.read(savedEnduranceTrainer.getIdEnduranceTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedEnduranceTrainer, read);
    }

    @Test
    public void e_delete() {
        EnduranceTrainer savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdEnduranceTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        EnduranceTrainer enduranceTrainer = new EnduranceTrainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + enduranceTrainer);
        EnduranceTrainer updated = this.repository.update(enduranceTrainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<EnduranceTrainer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}