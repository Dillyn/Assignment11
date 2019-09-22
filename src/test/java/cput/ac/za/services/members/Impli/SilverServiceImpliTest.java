package cput.ac.za.services.members.Impli;

import cput.ac.za.domain.members.Silver;
import cput.ac.za.factories.members.SilverMemberFactory;
import cput.ac.za.repositories.members.Impli.SilverRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SilverServiceImpliTest {

    private SilverRepositoryImpli repository;
    private Silver silver;

    private Silver getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (SilverRepositoryImpli) SilverRepositoryImpli.memberRepository();
        this.silver = SilverMemberFactory.getClasss("Dillyn", "Lakey");
    }

    @Test
    public void a_create() {
        Silver created = this.repository.create(this.silver);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.silver);
    }

    @Test
    public void c_update() {

        String name = "class";

        Silver updated = new Silver.Builder().copy(getSaved()).name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void e_delete() {
        Silver saved = getSaved();
        this.repository.delete(saved.getIdSilver());
        d_getAll();
    }

    @Test
    public void b_read() {
        Silver saved = getSaved();
        Silver read = this.repository.read(saved.getIdSilver());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Silver> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}