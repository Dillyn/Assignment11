package cput.ac.za.domain.staff;
import java.util.*;

/**
 * 
 */
public class SpeedTrainer {

    private String idSpeedTrainer ;

    private String name ;


    private String lastName ;


    private String title ;


    private SpeedTrainer(){}

    private SpeedTrainer(SpeedTrainer.Builder builder) {
        this.idSpeedTrainer = builder.idSpeedTrainer;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public String getIdSpeedTrainer() {
        return idSpeedTrainer;
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
        private String idSpeedTrainer;
        private String lastName;
        private String title ;


        public SpeedTrainer.Builder name(String name) {
            this.name = name;
            return this;
        }

        public SpeedTrainer.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public SpeedTrainer.Builder title(String title) {
            this.title = title;
            return this;
        }

        public SpeedTrainer.Builder idSpeedTrainer(String idSpeedTrainer) {
            this.idSpeedTrainer = idSpeedTrainer;
            return this;
        }


        public SpeedTrainer.Builder copy(SpeedTrainer speedTrainer){
            this.name = speedTrainer.getName();
            this.idSpeedTrainer = speedTrainer.getIdSpeedTrainer();
            this.lastName = speedTrainer.getLastName();
            this.title = speedTrainer.getTitle();
            return this;
        }

        public SpeedTrainer build() { return new SpeedTrainer(this);
        }

    }

    @Override
    public String toString() {
        return "SpeedTrainer{" +
                "SpeedTrainerId='" + idSpeedTrainer+ '\'' +
                ", SpeedTrainerName='" + name + '\'' +
                ", SpeedTrainerLastName='" + lastName + '\'' +
                ", SpeedTrainerTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeedTrainer staff = (SpeedTrainer) o;
        return Objects.equals(idSpeedTrainer, staff.idSpeedTrainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSpeedTrainer);
    }

}