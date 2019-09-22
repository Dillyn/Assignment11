package cput.ac.za.domain.classes;
import java.util.*;

/**
 * 
 */
public class Classs {

    private String idClass;

    private String name ;
    /**
     * Default constructor
     */

    private Classs(){}

    private Classs(Classs.Builder builder) {
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

        public Classs.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Classs.Builder idClass(String idClass) {
            this.idClass = idClass;
            return this;
        }


        public Builder copy(Classs classs){
            this.name = classs.getName();
            this.idClass = classs.getIdClass();
            return this;
        }

        public Classs build() {
            return new Classs(this);
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
        Classs classs = (Classs) o;
        return Objects.equals(idClass, classs.idClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClass);
    }

}

