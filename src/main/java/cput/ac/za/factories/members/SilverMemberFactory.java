package cput.ac.za.factories.members;

import cput.ac.za.domain.members.Silver;
import cput.ac.za.util.Helper;

public class SilverMemberFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SilverMemberFactory.class);

    public static Silver getClasss( String name, String lastName) {
        return new Silver.Builder()
                .idSilver(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .build();
    }
}
