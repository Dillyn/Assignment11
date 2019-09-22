package cput.ac.za.repositories.members.Impli;

import cput.ac.za.domain.members.Gold;
import cput.ac.za.factories.members.GoldMemberFactory;
import cput.ac.za.repositories.members.GoldRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GoldRepositoryImpliTest {

    private GoldRepository repository;
    private Gold gold;

    private Gold getSavedClass() {
        Set<Gold> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = GoldRepositoryImpli.memberRepository();
        this.gold = GoldMemberFactory.getClasss("Dillyn", "Lakey");
    }

    @Test
    public void a_create() {
        Gold created = this.repository.create(this.gold);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.gold);
    }

    @Test
    public void b_read() {
        Gold savedGold = getSavedClass();
        System.out.println("In read, genderId = "+ savedGold.getIdGold());
        Gold read = this.repository.read(savedGold.getIdGold());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedGold, read);
    }

    @Test
    public void e_delete() {
        Gold savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdGold());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Gold gold = new Gold.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + gold);
        Gold updated = this.repository.update(gold);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Gold> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}