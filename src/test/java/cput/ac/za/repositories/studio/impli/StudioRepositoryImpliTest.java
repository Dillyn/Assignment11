package cput.ac.za.repositories.studio.impli;

import cput.ac.za.domain.studio.Studio;
import cput.ac.za.factories.studio.StudioFactory;
import cput.ac.za.repositories.studio.StudioRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudioRepositoryImpliTest {

    private StudioRepository repository;
    private Studio studio;

    private Studio getSavedClass() {
        Set<Studio> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.repository = StudioRepositoryImpli.studioRepository();
        this.studio = StudioFactory.getStudio("Dillyn");
    }

    @Test
    public void a_create() {
        Studio created = this.repository.create(this.studio);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.studio);
    }

    @Test
    public void b_read() {
        Studio savedStudio = getSavedClass();
        System.out.println("In read, genderId = "+ savedStudio.getId());
        Studio read = this.repository.read(savedStudio.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStudio, read);
    }

    @Test
    public void e_delete() {
        Studio savedGender = getSavedClass();
        this.repository.delete(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Studio studio = new Studio.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + studio);
        Studio updated = this.repository.update(studio);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Studio> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}