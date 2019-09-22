package cput.ac.za.repositories.classes.Impli;

import cput.ac.za.domain.classes.Classs;
import cput.ac.za.factories.classes.ClasssFactory;
import cput.ac.za.repositories.classes.ClassRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClassRepositoryImpliTest {

    private ClassRepository repository;
    private Classs classs;

    private Classs getSavedClass() {
        Set<Classs> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ClassRepositoryImpli.classRepository();
        this.classs = ClasssFactory.getClasss("Spinning");
    }

    @Test
    public void a_create() {
        Classs created = this.repository.create(this.classs);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.classs);
    }

    @Test
    public void b_read() {
        Classs savedClasss = getSavedClass();
        System.out.println("In read, genderId = "+ savedClasss.getIdClass());
        Classs read = this.repository.read(savedClasss.getIdClass());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedClasss, read);
    }

    @Test
    public void e_delete() {
        Classs savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdClass());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Classs classs = new Classs.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + classs);
        Classs updated = this.repository.update(classs);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Classs> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}