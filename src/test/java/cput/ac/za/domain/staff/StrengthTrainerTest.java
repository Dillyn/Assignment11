package cput.ac.za.domain.staff;

import cput.ac.za.domain.staff.StrengthTrainer;
import cput.ac.za.factories.staff.StrengthTrainerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrengthTrainerTest {
    @Test
    public void getStrengthTrainer() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        StrengthTrainer c = StrengthTrainerFactory.getStrengthTrainer( name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdStrengthTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}