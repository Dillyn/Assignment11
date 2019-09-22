package cput.ac.za.domain.members;
import java.util.*;

/**
 * 
 */
public class Bronze {

    private String idBronze ;

    private String name ;

    private String lastName ;


    /**
     *
     */


    private Bronze(){}

    private Bronze(Bronze.Builder builder) {
        this.idBronze = builder.idBronze;
        this.name = builder.name;
        this.lastName = builder.lastName;
    }


    public String getIdBronze() {
        return idBronze;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder {

        private String name;
        private String idBronze;
        private String lastName;

        public Bronze.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Bronze.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Bronze.Builder idBronze(String idBronze) {
            this.idBronze = idBronze;
            return this;
        }


        public Bronze.Builder copy(Bronze bronze){
            this.name = bronze.getName();
            this.idBronze = bronze.getIdBronze();
            this.lastName = bronze.getLastName();
            return this;
        }

        public Bronze build() { return new Bronze(this);
        }

    }

    @Override
    public String toString() {
        return "BronzeMember{" +
                "BronzeMemberId='" + idBronze+ '\'' +
                ", BronzeMemberName='" + name + '\'' +
                ", BronzeMemberLastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bronze member = (Bronze) o;
        return Objects.equals(idBronze, member.idBronze);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBronze);
    }

}