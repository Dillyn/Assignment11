package cput.ac.za.services.members.Impli;

import cput.ac.za.domain.members.Bronze;
import cput.ac.za.factories.members.BronzeMemberFactory;
import cput.ac.za.repositories.members.Impli.BronzeRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BronzeServiceImpliTest {

    private BronzeRepositoryImpli repository;
    private Bronze bronze;

    private Bronze getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (BronzeRepositoryImpli) BronzeRepositoryImpli.memberRepository();
        this.bronze = BronzeMemberFactory.getClasss("Dillyn", "Lakey");
    }

    @Test
    public void a_create() {
        Bronze created = this.repository.create(this.bronze);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.bronze);
    }

    @Test
    public void c_update() {

        String name = "class";

        Bronze updated = new Bronze.Builder().copy(getSaved()).name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void e_delete() {
        Bronze saved = getSaved();
        this.repository.delete(saved.getIdBronze());
        d_getAll();
    }

    @Test
    public void b_read() {
        Bronze saved = getSaved();
        Bronze read = this.repository.read(saved.getIdBronze());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Bronze> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}