package cput.ac.za.domain.classes;
import java.util.*;

/**
 * 
 */
public class Speed  {

    private String idClass;

    private String name ;
    /**
     * Default constructor
     */

    private Speed(){}

    private Speed(Speed.Builder builder) {
        this.idClass = builder.idClass;
        this.name = builder.name;
    }

    public String getIdClass() {
        return idClass;
    }

    public String getName() {
        return name;
    }




    public static class Builder {

        private String name;
        private String idClass;

        public Speed.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Speed.Builder idClass(String idClass) {
            this.idClass = idClass;
            return this;
        }


        public Speed.Builder copy(Speed classs){
            this.name = classs.getName();
            this.idClass = classs.getIdClass();
            return this;
        }

        public Speed build() {
            return new Speed(this);
        }

    }

    @Override
    public String toString() {
        return "Class{" +
                "ClassId='" + idClass + '\'' +
                ", ClassName='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speed classs = (Speed) o;
        return Objects.equals(idClass, classs.idClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClass);
    }

}