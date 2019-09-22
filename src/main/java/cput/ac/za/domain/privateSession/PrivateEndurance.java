package cput.ac.za.domain.privateSession;
import java.util.*;

/**
 * 
 */
public class PrivateEndurance {


    private String type, id;

    private Date date;


    private PrivateEndurance() {
    }

    private PrivateEndurance(PrivateEndurance.Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.type = builder.type;
    }

public String getId() { return id;}

    public Date getDate() {
        return date;
    }

    public String getType() { return type; }


    public static class Builder {

        private Date date;
        private String type, id;

        public PrivateEndurance.Builder id(String id){
            this.id = id;
            return this;
        }

        public PrivateEndurance.Builder date(Date date) {
            this.date = date;
            return this;
        }

        public PrivateEndurance.Builder type(String type) {
            this.type = type;
            return this;
        }

        public PrivateEndurance.Builder copy(PrivateEndurance privateEndurance) {
            this.id = privateEndurance.getId();
            this.date = privateEndurance.getDate();
            this.type = privateEndurance.getType();
            return this;
        }

        public PrivateEndurance build() {
            return new PrivateEndurance(this);
        }

    }

    @Override
    public String toString() {
        return "PrivateEndurance{" +
                "PrivateEnduranceId'" + id + '\'' +
                "PrivateEnduranceDate'" + date + '\'' +
                "PrivateEnduranceType'" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateEndurance session = (PrivateEndurance) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}