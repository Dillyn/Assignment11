package cput.ac.za.factories.staff;

import cput.ac.za.domain.staff.HelpDesk;
import cput.ac.za.util.Helper;

public class HelpDeskFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(HelpDeskFactory.class);

    public static HelpDesk getHelpDesk( String name, String lastName, String title) {
        return new HelpDesk.Builder()
                .idHelpDesk(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
