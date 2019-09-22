package cput.ac.za.domain.session;

import java.util.*;
import java.util.Date;

/**
 *
 */
public class Session {

    private String id;

    private Date date;

    private Session() {
    }

    private Session(Session.Builder builder) {
        this.id = builder.id;
        this.date = builder.date;

    }

    public String getId() {
        return id;
    }

    public Date getSessionDate() {
        return date;
    }


    public static class Builder {

        private String id;
        private Date date;

        public Session.Builder id(String id) {
            this.id = id;
            return this;
        }

        public Session.Builder date(Date date) {
            this.date = date;
            return this;
        }


        public Session.Builder copy(Session session) {
            this.id = session.getId();
            this.date = session.getSessionDate();

            return this;
        }

        public Session build() {
            return new Session(this);
        }

    }

    @Override
    public String toString() {
        return "Session{" +
                "SessionId'" + id + '\'' +
                "SessionDate='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}