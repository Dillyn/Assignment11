package cput.ac.za.domain.privateSession;

import cput.ac.za.domain.privateSession.PrivateEndurance;
import cput.ac.za.factories.privateSessions.PrivateEnduranceFactory;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PrivateEnduranceTest {
    @Test
    public void getPrivateEnduranceSession() {
        // String pattern = "yyyy-MM-dd-15:58";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        String type = "turbo";
        //date = simpleDateFormat.parse("2018-09-09");


        PrivateEndurance c = PrivateEnduranceFactory.getPrivateEndurance(date,type);
        System.out.println(c);
        assertNotNull(c.getDate()+"\n"+c.getType());
    }
}