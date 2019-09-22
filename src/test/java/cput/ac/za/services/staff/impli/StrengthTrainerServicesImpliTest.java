package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.classes.Strength;
import cput.ac.za.domain.staff.StrengthTrainer;
import cput.ac.za.factories.classes.StrengthClassFactory;
import cput.ac.za.factories.staff.StrengthTrainerFactory;
import cput.ac.za.repositories.classes.Impli.StrengthRepositoryImpli;
import cput.ac.za.repositories.staff.impli.StrengthTrainerRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StrengthTrainerServicesImpliTest {

    private StrengthTrainerRepositoryImpli repository;
    private StrengthTrainer privateStrength;

    private StrengthTrainer getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (StrengthTrainerRepositoryImpli) StrengthTrainerRepositoryImpli.strengthTrainerRepository();
        this.privateStrength = StrengthTrainerFactory.getStrengthTrainer("Dillyn", "Lakey", "Cheese");
    }

    @Test
    public void a_create() {
        StrengthTrainer created = this.repository.create(this.privateStrength);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateStrength);
    }

    @Test
    public void c_update() {
        String date = "Mozorella";

        StrengthTrainer updated = new StrengthTrainer.Builder().copy(getSaved()).name(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getName());
    }

    @Test
    public void e_delete() {
        StrengthTrainer saved = getSaved();
        this.repository.delete(saved.getIdStrengthTrainer());
        d_getAll();
    }

    @Test
    public void b_read() {
        StrengthTrainer saved = getSaved();
        StrengthTrainer read = this.repository.read(saved.getIdStrengthTrainer());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<StrengthTrainer> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}