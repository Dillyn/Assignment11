package cput.ac.za.domain.staff;
import java.util.*;

/**
 * 
 */
public class Staff {

    /**
     * Default constructor
     */


    private String idStaff ;

    private String name ;


    private String lastName ;


    private String title ;


    private Staff(){}

    private Staff(Staff.Builder builder) {
        this.idStaff = builder.idStaff;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public String getIdStaff() {
        return idStaff;
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
        private String idStaff;
        private String lastName;
        private String title ;


        public Staff.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Staff.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Staff.Builder title(String title) {
            this.title = title;
            return this;
        }

        public Staff.Builder idStaff(String idStaff) {
            this.idStaff = idStaff;
            return this;
        }


        public Staff.Builder copy(Staff staff){
            this.idStaff = staff.getIdStaff();
            this.name = staff.getName();
            this.lastName = staff.getLastName();
            this.title = staff.getTitle();
            return this;
        }

        public Staff build() { return new Staff(this);
        }

    }

    @Override
    public String toString() {
        return "Staff{" +
                "StaffId='" + idStaff+ '\'' +
                ", StaffName='" + name + '\'' +
                ", StaffLastName='" + lastName + '\'' +
                ", StaffTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(idStaff, staff.idStaff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStaff);
    }

}