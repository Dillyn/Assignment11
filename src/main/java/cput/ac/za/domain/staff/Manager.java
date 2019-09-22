package cput.ac.za.domain.staff;
import java.util.*;

/**
 * 
 */
public class Manager{

    private String idManager ;

    private String name ;


    private String lastName ;


    private String title ;


    private Manager(){}

    private Manager(Manager.Builder builder) {
        this.idManager = builder.idManager;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public String getIdManager() {
        return idManager;
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
        private String idManager;
        private String lastName;
        private String title ;


        public Manager.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Manager.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Manager.Builder title(String title) {
            this.title = title;
            return this;
        }

        public Manager.Builder idManager(String idManager) {
            this.idManager = idManager;
            return this;
        }


        public Manager.Builder copy(Manager manager){
            this.name = manager.getName();
            this.idManager = manager.getIdManager();
            this.lastName = manager.getLastName();
            this.title = manager.getTitle();
            return this;
        }

        public Manager build() { return new Manager(this);
        }

    }

    @Override
    public String toString() {
        return "Manager{" +
                "ManagerId='" + idManager+ '\'' +
                ", ManagerName='" + name + '\'' +
                ", ManagerLastName='" + lastName + '\'' +
                ", ManagerTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager staff = (Manager) o;
        return Objects.equals(idManager, staff.idManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idManager);
    }

}