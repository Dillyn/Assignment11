package cput.ac.za.domain.staff;

import cput.ac.za.domain.staff.SpeedTrainer;
import cput.ac.za.factories.staff.SpeedTrainerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpeedTrainerTest {
    @Test
    public void getTrainer() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        SpeedTrainer c = SpeedTrainerFactory.getSpeedTrainer( name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdSpeedTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}