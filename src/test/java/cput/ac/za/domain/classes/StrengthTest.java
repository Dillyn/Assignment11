package cput.ac.za.domain.classes;

import cput.ac.za.domain.classes.Strength;
import cput.ac.za.factories.classes.StrengthClassFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrengthTest {
    @Test
    public void getClasss() {

        String name = "Strength";


        Strength c = StrengthClassFactory.getClasss( name);
        System.out.println(c);
        assertNotNull(c.getIdClass()+"\n"+c.getName());
    }

}