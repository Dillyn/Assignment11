package cput.ac.za.domain.classes;

import cput.ac.za.domain.classes.Endurance;
import cput.ac.za.factories.classes.EnduranceClassFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnduranceTest {

    @Test
    public void getenduranceClasss() {


        String name = "Sprint";


        Endurance c = EnduranceClassFactory.getClasss( name);
        System.out.println(c);
        assertNotNull(c.getIdClass()+"\n"+c.getName());
    }

}