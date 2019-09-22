package cput.ac.za.services.studio.impli;

import cput.ac.za.domain.studio.Studio;
import cput.ac.za.factories.studio.StudioFactory;
import cput.ac.za.repositories.studio.impli.StudioRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudioServicesImpliTest {

    private StudioRepositoryImpli repository;
    private Studio privateStudio;

    private Studio getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (StudioRepositoryImpli) StudioRepositoryImpli.studioRepository();
        this.privateStudio = StudioFactory.getStudio("VX");
    }

    @Test
    public void a_create() {
        Studio created = this.repository.create(this.privateStudio);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.privateStudio);
    }

    @Test
    public void c_update() {
        String date = "VXX";

        Studio updated = new Studio.Builder().copy(getSaved()).name(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getName());
    }

    @Test
    public void e_delete() {
        Studio saved = getSaved();
        this.repository.delete(saved.getId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Studio saved = getSaved();
        Studio read = this.repository.read(saved.getId());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Studio> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}