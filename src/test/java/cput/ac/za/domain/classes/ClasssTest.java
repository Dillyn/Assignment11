package cput.ac.za.domain.classes;

import cput.ac.za.domain.classes.Classs;
import cput.ac.za.factories.classes.ClasssFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClasssTest {

    @Test
    public void getClasss() {


        String name = "Zumba";


        Classs c = ClasssFactory.getClasss( name);
        System.out.println(c);
        assertNotNull(c.getIdClass()+"\n"+c.getName());
    }

}