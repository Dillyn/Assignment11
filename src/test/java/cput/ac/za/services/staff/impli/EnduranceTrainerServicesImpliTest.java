package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.SpeedTrainer;
import cput.ac.za.factories.staff.SpeedTrainerFactory;
import cput.ac.za.repositories.staff.impli.SpeedTrainerRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnduranceTrainerServicesImpliTest {

    private SpeedTrainerRepositoryImpli repository;
    private SpeedTrainer privateSpeed;

    private SpeedTrainer getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (SpeedTrainerRepositoryImpli) SpeedTrainerRepositoryImpli.speedTrainerRepository();
        this.privateSpeed = SpeedTrainerFactory.getSpeedTrainer("Dillyn", "Lakey", "Cheese");
    }

    @Test
    public void a_create() {
        SpeedTrainer created = this.repository.create(this.privateSpeed);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateSpeed);
    }

    @Test
    public void c_update() {
        String date = "Mozorella";

        SpeedTrainer updated = new SpeedTrainer.Builder().copy(getSaved()).name(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getName());
    }

    @Test
    public void e_delete() {
        SpeedTrainer saved = getSaved();
        this.repository.delete(saved.getIdSpeedTrainer());
        d_getAll();
    }

    @Test
    public void b_read() {
        SpeedTrainer saved = getSaved();
        SpeedTrainer read = this.repository.read(saved.getIdSpeedTrainer());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<SpeedTrainer> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}