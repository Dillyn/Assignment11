package cput.ac.za.domain.staff;

import cput.ac.za.domain.staff.EnduranceTrainer;
import cput.ac.za.factories.staff.EnduranceTrainerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnduranceTrainerTest {
    @Test
    public void getTrainer() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        EnduranceTrainer c = EnduranceTrainerFactory.getEnduranceTrainer( name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdEnduranceTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}