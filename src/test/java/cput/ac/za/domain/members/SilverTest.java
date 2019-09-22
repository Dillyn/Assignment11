package cput.ac.za.domain.members;

import cput.ac.za.domain.members.Silver;
import cput.ac.za.factories.members.SilverMemberFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SilverTest {
    @Test
    public void getSilverMember() {


        String name = "joe";
        String lastName = "Zoe";


        Silver c = SilverMemberFactory.getClasss( name,lastName);
        System.out.println(c);
        assertNotNull(c.getIdSilver()+"\n"+c.getName());
    }

}