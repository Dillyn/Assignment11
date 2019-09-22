package cput.ac.za.services.members.Impli;

import cput.ac.za.domain.members.Gold;
import cput.ac.za.factories.members.GoldMemberFactory;
import cput.ac.za.repositories.members.Impli.GoldRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoldServiceImpliTest {

    private GoldRepositoryImpli repository;
    private Gold gold;

    private Gold getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (GoldRepositoryImpli) GoldRepositoryImpli.memberRepository();
        this.gold = GoldMemberFactory.getClasss("Dillyn", "Lakey");
    }

    @Test
    public void a_create() {
        Gold created = this.repository.create(this.gold);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.gold);
    }

    @Test
    public void c_update() {

        String name = "class";

        Gold updated = new Gold.Builder().copy(getSaved()).name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void e_delete() {
        Gold saved = getSaved();
        this.repository.delete(saved.getIdGold());
        d_getAll();
    }

    @Test
    public void b_read() {
        Gold saved = getSaved();
        Gold read = this.repository.read(saved.getIdGold());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Gold> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}