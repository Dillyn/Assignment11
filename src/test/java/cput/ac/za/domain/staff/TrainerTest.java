package cput.ac.za.domain.staff;

import cput.ac.za.domain.staff.Trainer;
import cput.ac.za.factories.staff.TrainerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrainerTest {
    @Test
    public void getTrainer() {

        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        Trainer c = TrainerFactory.getTrainer( name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}