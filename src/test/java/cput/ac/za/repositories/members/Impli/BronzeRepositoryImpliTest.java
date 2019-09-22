package cput.ac.za.repositories.members.Impli;

import cput.ac.za.domain.members.Bronze;
import cput.ac.za.factories.members.BronzeMemberFactory;
import cput.ac.za.repositories.members.BronzeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BronzeRepositoryImpliTest {

    private BronzeRepository repository;
    private Bronze bronze;

    private Bronze getSavedClass() {
        Set<Bronze> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BronzeRepositoryImpli.memberRepository();
        this.bronze = BronzeMemberFactory.getClasss("Dillyn", "Lakey");
    }

    @Test
    public void a_create() {
        Bronze created = this.repository.create(this.bronze);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.bronze);
    }

    @Test
    public void b_read() {
        Bronze savedBronze = getSavedClass();
        System.out.println("In read, genderId = "+ savedBronze.getIdBronze());
        Bronze read = this.repository.read(savedBronze.getIdBronze());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedBronze, read);
    }

    @Test
    public void e_delete() {
        Bronze savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdBronze());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Bronze bronze = new Bronze.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + bronze);
        Bronze updated = this.repository.update(bronze);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Bronze> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}