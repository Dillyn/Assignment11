package cput.ac.za.domain.members;

import cput.ac.za.domain.members.Gold;
import cput.ac.za.factories.members.GoldMemberFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoldTest {
    @Test
    public void getGoldMember() {


        String name = "joe";
        String lastName = "Zoe";


        Gold c = GoldMemberFactory.getClasss( name,lastName);
        System.out.println(c);
        assertNotNull(c.getIdGold()+"\n"+c.getName());
    }

}