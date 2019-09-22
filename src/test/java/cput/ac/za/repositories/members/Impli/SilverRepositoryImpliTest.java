package cput.ac.za.repositories.members.Impli;

import cput.ac.za.domain.members.Silver;
import cput.ac.za.factories.members.SilverMemberFactory;
import cput.ac.za.repositories.members.SilverRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SilverRepositoryImpliTest {

    private SilverRepository repository;
    private Silver silver;

    private Silver getSavedClass() {
        Set<Silver> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SilverRepositoryImpli.memberRepository();
        this.silver = SilverMemberFactory.getClasss("Dillyn", "Lakey");
    }

    @Test
    public void a_create() {
        Silver created = this.repository.create(this.silver);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.silver);
    }

    @Test
    public void b_read() {
        Silver savedSilver = getSavedClass();
        System.out.println("In read, genderId = "+ savedSilver.getIdSilver());
        Silver read = this.repository.read(savedSilver.getIdSilver());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSilver, read);
    }

    @Test
    public void e_delete() {
        Silver savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdSilver());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Silver silver = new Silver.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + silver);
        Silver updated = this.repository.update(silver);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Silver> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}