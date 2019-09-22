package cput.ac.za.factories.members;

import cput.ac.za.domain.members.Member;
import cput.ac.za.util.Helper;

public class MemberFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(MemberFactory.class);

    public static Member getClasss( String id,String name, String lastName) {
        return new Member.Builder()
                .idMember(id)
                .name(name)
                .lastName(lastName)
                .build();
    }
}
