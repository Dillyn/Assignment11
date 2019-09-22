package cput.ac.za.factories.staff;

import cput.ac.za.domain.staff.Staff;
import cput.ac.za.util.Helper;

public class StaffFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StaffFactory.class);

    public static Staff getStaff( String id,String name, String lastName, String title) {
        return new Staff.Builder()
                .idStaff(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
