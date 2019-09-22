package cput.ac.za.domain.privateSession;

import java.util.*;

/**
 *
 */
public class PrivateSession {


    private String type, id;

    private Date date;


    private PrivateSession() {
    }

    private PrivateSession(PrivateSession.Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.type = builder.type;
    }

public String getId(){ return id;}

    public Date getPrivateSessionDate() {
        return date;
    }

    public String getType() { return type; }


    public static class Builder {

        private Date date;
        private String type, id;

        public PrivateSession.Builder id(String id){
            this.id = id;
            return this;
        }

        public PrivateSession.Builder date(Date date) {
            this.date = date;
            return this;
        }

        public PrivateSession.Builder type(String type) {
            this.type = type;
            return this;
        }

        public PrivateSession.Builder copy(PrivateSession privateSession) {
            this.id = privateSession.getId();
            this.date = privateSession.getPrivateSessionDate();
            this.type = privateSession.getType();
            return this;
        }

        public PrivateSession build() {
            return new PrivateSession(this);
        }

    }

    @Override
    public String toString() {
        return "PrivateSession{" +
                "PrivateSessionId'" + id + '\'' +
                "PrivateSessionDate'" + date + '\'' +
                "PrivateSessionType'" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateSession session = (PrivateSession) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}