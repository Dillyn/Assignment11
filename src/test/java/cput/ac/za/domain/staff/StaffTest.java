package cput.ac.za.domain.staff;

import cput.ac.za.domain.staff.Staff;
import cput.ac.za.factories.staff.StaffFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffTest {
    @Test
    public void getStaff() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        Staff c = StaffFactory.getStaff("1",name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdStaff()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}