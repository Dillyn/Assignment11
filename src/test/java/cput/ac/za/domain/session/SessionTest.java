package cput.ac.za.domain.session;


import cput.ac.za.domain.session.Session;
import cput.ac.za.factories.session.SessionFactory;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class SessionTest {
    @Test
    public void getSession() throws ParseException {
       // String pattern = "yyyy-MM-dd-15:58";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        //date = simpleDateFormat.parse("2018-09-09");


        Session c = SessionFactory.getSession(date);
        System.out.println(c);
        assertNotNull(c.getSessionDate());
    }

}