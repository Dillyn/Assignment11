package cput.ac.za.domain.classes;

import cput.ac.za.domain.classes.Speed;
import cput.ac.za.factories.classes.SpeedClassFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpeedTest {
    @Test
    public void getClasss() {


        String name = "Explosive";


        Speed c = SpeedClassFactory.getClasss( name);
        System.out.println(c);
        assertNotNull(c.getIdClass()+"\n"+c.getName());
    }

}