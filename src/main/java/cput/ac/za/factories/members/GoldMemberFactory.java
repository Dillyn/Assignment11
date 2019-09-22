package cput.ac.za.factories.members;

import cput.ac.za.domain.members.Gold;
import cput.ac.za.util.Helper;

public class GoldMemberFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(GoldMemberFactory.class);

    public static Gold getClasss( String name, String lastName) {
        return new Gold.Builder()
                .idGold(Helper.generateRandomGivenSuffix(SUFFIX))
                .name(name)
                .lastName(lastName)
                .build();
    }
}
