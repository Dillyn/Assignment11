package cput.ac.za.domain.staff;

import cput.ac.za.domain.staff.CompleteTrainer;
import cput.ac.za.factories.staff.CompleteTrainerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompleteTrainerTest {
    @Test
    public void getTrainer() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        CompleteTrainer c = CompleteTrainerFactory.getCompleteTrainer( name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdCompleteTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}