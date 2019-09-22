package cput.ac.za.domain.members;


import cput.ac.za.domain.members.Member;
import cput.ac.za.factories.members.MemberFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
    @Test
    public void getMember() {


        String name = "joe";
        String lastName = "Zoe";


        Member c = MemberFactory.getClasss("1" ,name,lastName);
        System.out.println(c);
        assertNotNull(c.getIdMember()+"\n"+c.getName());
    }

}