package cput.ac.za.domain.studio;

import java.util.*;

/**
 *
 */
public class Studio {


    private String name, id;


    private Studio() {
    }

    private Studio(Studio.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public static class Builder {

        private String name, id;

        public Studio.Builder id(String id) {
            this.id = id;
            return this;
        }

        public Studio.Builder name(String name) {
            this.name = name;
            return this;
        }


        public Studio.Builder copy(Studio studio) {
            this.id = studio.getId();
            this.name = studio.getName();
            return this;
        }

        public Studio build() {
            return new Studio(this);
        }

    }

    @Override
    public String toString() {
        return "Studio{StudioId='" + id + '\'' +
                ", Studio='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studio staff = (Studio) o;
        return staff.equals(staff.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}