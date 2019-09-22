package cput.ac.za.domain.members;

import cput.ac.za.domain.members.Bronze;
import cput.ac.za.factories.members.BronzeMemberFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class BronzeTest {
    @Test
    public void getBronzeMember() {


        String name = "joe";
        String lastName = "Zoe";


        Bronze c = BronzeMemberFactory.getClasss( name,lastName);
        System.out.println(c);
        assertNotNull(c.getIdBronze()+"\n"+c.getName());
    }

}