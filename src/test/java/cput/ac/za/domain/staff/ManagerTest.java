package cput.ac.za.domain.staff;

import cput.ac.za.domain.staff.Manager;
import cput.ac.za.factories.staff.ManagerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    @Test
    public void getManager() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        Manager c = ManagerFactory.getManager(name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdManager()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}