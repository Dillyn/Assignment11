package cput.ac.za.domain.privateSession;
import java.util.*;

/**
 * 
 */
public class PrivateSpeed {


    private String type, id;

    private Date date;


    private PrivateSpeed() {
    }

    private PrivateSpeed(PrivateSpeed.Builder builder) {
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

        public PrivateSpeed.Builder id(String id){
            this.id = id;
            return this;
        }

        public PrivateSpeed.Builder date(Date date) {
            this.date = date;
            return this;
        }

        public PrivateSpeed.Builder type(String type) {
            this.type = type;
            return this;
        }

        public PrivateSpeed.Builder copy(PrivateSpeed privateSpeed) {
           this.id = privateSpeed.getId();
            this.date = privateSpeed.getDate();
            this.type = privateSpeed.getType();
            return this;
        }

        public PrivateSpeed build() {
            return new PrivateSpeed(this);
        }

    }

    @Override
    public String toString() {
        return "PrivateSpeed{" +
                "PrivateSpeedId'" + id + '\'' +
                "PrivateSpeedDate'" + date + '\'' +
                "PrivateSpeedType'" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateSpeed session = (PrivateSpeed) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}