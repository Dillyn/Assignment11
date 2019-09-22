package cput.ac.za.domain.staff;

import java.util.*;

/**
 * 
 */
public class Trainer {

    private String idTrainer ;

    private String name ;


    private String lastName ;


    private String title ;


    private Trainer(){}

    private Trainer(Trainer.Builder builder) {
        this.idTrainer = builder.idTrainer;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public String getIdTrainer() {
        return idTrainer;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }


    public static class Builder {

        private String name;
        private String idTrainer;
        private String lastName;
        private String title ;


        public Trainer.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Trainer.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Trainer.Builder title(String title) {
            this.title = title;
            return this;
        }

        public Trainer.Builder idTrainer(String idTrainer) {
            this.idTrainer = idTrainer;
            return this;
        }


        public Trainer.Builder copy(Trainer trainer){
            this.name = trainer.getName();
            this.idTrainer = trainer.getIdTrainer();
            this.lastName = trainer.getLastName();
            this.title = trainer.getTitle();
            return this;
        }

        public Trainer build() { return new Trainer(this);
        }

    }

    @Override
    public String toString() {
        return "Trainer{" +
                "TrainerId='" + idTrainer+ '\'' +
                ", TrainerName='" + name + '\'' +
                ", TrainerLastName='" + lastName + '\'' +
                ", TrainerTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer staff = (Trainer) o;
        return Objects.equals(idTrainer, staff.idTrainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrainer);
    }

}