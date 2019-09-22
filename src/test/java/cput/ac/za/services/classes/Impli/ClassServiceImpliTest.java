package cput.ac.za.services.classes.Impli;

import cput.ac.za.domain.classes.Classs;
import cput.ac.za.factories.classes.ClasssFactory;
import cput.ac.za.repositories.classes.Impli.ClassRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassServiceImpliTest {

    private ClassRepositoryImpli repository;
    private Classs classs;

    private Classs getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (ClassRepositoryImpli) ClassRepositoryImpli.classRepository();
        this.classs = ClasssFactory.getClasss("Dillyn");
    }

    @Test
    public void a_create() {
        Classs created = this.repository.create(this.classs);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.classs);
    }

    @Test
    public void c_update() {

        String name = "class";

        Classs updated = new Classs.Builder().copy(getSaved()).name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void e_delete() {
        Classs saved = getSaved();
        this.repository.delete(saved.getIdClass());
        d_getAll();
    }

    @Test
    public void b_read() {
        Classs saved = getSaved();
        Classs read = this.repository.read(saved.getIdClass());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Classs> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}