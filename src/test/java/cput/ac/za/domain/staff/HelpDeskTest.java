package cput.ac.za.domain.staff;

import cput.ac.za.domain.staff.HelpDesk;
import cput.ac.za.factories.staff.HelpDeskFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelpDeskTest {
    @Test
    public void getHelpDesk() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "helper";


        HelpDesk c = HelpDeskFactory.getHelpDesk( name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdHelpDesk()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}