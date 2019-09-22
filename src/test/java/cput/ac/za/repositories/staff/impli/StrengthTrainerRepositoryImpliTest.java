package cput.ac.za.repositories.staff.impli;

import cput.ac.za.domain.staff.StrengthTrainer;
import cput.ac.za.factories.staff.StrengthTrainerFactory;
import cput.ac.za.repositories.staff.StrengthTrainerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StrengthTrainerRepositoryImpliTest {

    private StrengthTrainerRepository repository;
    private StrengthTrainer strengthTrainer;

    private StrengthTrainer getSavedClass() {
        Set<StrengthTrainer> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = StrengthTrainerRepositoryImpli.strengthTrainerRepository();
        this.strengthTrainer = StrengthTrainerFactory.getStrengthTrainer("Dillyn","Lakey","Boss");
    }

    @Test
    public void a_create() {
        StrengthTrainer created = this.repository.create(this.strengthTrainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.strengthTrainer);
    }

    @Test
    public void b_read() {
        StrengthTrainer savedStrengthTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedStrengthTrainer.getIdStrengthTrainer());
        StrengthTrainer read = this.repository.read(savedStrengthTrainer.getIdStrengthTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStrengthTrainer, read);
    }

    @Test
    public void e_delete() {
        StrengthTrainer savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdStrengthTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        StrengthTrainer strengthTrainer = new StrengthTrainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + strengthTrainer);
        StrengthTrainer updated = this.repository.update(strengthTrainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<StrengthTrainer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}