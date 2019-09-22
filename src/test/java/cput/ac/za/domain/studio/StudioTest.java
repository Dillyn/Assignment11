package cput.ac.za.domain.studio;

import cput.ac.za.domain.studio.Studio;
import cput.ac.za.factories.studio.StudioFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudioTest {
    @Test
    public void getStudio() {


        String name = "Studio1";



        Studio c = StudioFactory.getStudio( name);
        System.out.println(c);
        assertNotNull(c.getName());
    }

}