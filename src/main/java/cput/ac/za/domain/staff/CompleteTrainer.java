package cput.ac.za.domain.staff;
import java.util.*;

/**
 * 
 */
public class CompleteTrainer {

    private String idCompleteTrainer ;

    private String name ;


    private String lastName ;


    private String title ;


    private CompleteTrainer(){}

    private CompleteTrainer(CompleteTrainer.Builder builder) {
        this.idCompleteTrainer = builder.idCompleteTrainer;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public String getIdCompleteTrainer() {
        return idCompleteTrainer;
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
        private String idCompleteTrainer;
        private String lastName;
        private String title ;


        public CompleteTrainer.Builder name(String name) {
            this.name = name;
            return this;
        }

        public CompleteTrainer.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CompleteTrainer.Builder title(String title) {
            this.title = title;
            return this;
        }

        public CompleteTrainer.Builder idCompleteTrainer(String idCompleteTrainer) {
            this.idCompleteTrainer = idCompleteTrainer;
            return this;
        }


        public CompleteTrainer.Builder copy(CompleteTrainer completeYrainer){
            this.name = completeYrainer.getName();
            this.idCompleteTrainer = completeYrainer.getIdCompleteTrainer();
            this.lastName = completeYrainer.getLastName();
            this.title = completeYrainer.getTitle();
            return this;
        }

        public CompleteTrainer build() { return new CompleteTrainer(this);
        }

    }

    @Override
    public String toString() {
        return "CompleteTrainer{" +
                "CompleteTrainerId='" + idCompleteTrainer+ '\'' +
                ", CompleteTrainerName='" + name + '\'' +
                ", CompleteTrainerLastName='" + lastName + '\'' +
                ", CompleteTrainerTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteTrainer staff = (CompleteTrainer) o;
        return Objects.equals(idCompleteTrainer, staff.idCompleteTrainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompleteTrainer);
    }

}