package cput.ac.za.domain.members;

import java.util.*;

/**
 * 
 */
public class Member {

    private String idMember ;

    private String name ;

    private String lastName ;


    /**
     * 
     */


    private Member(){}

    private Member(Member.Builder builder) {
        this.idMember = builder.idMember;
        this.name = builder.name;
        this.lastName = builder.lastName;
    }


    public String getIdMember() {
        return idMember;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder {

        private String name;
        private String idMember;
        private String lastName;

        public Member.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Member.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Member.Builder idMember(String idMember) {
            this.idMember = idMember;
            return this;
        }


        public Member.Builder copy(Member member){
            this.name = member.getName();
            this.idMember = member.getIdMember();
            this.lastName = member.getLastName();
            return this;
        }

        public Member build() { return new Member(this);
        }

    }

    @Override
    public String toString() {
        return "Member{" +
                "MemberId='" + idMember+ '\'' +
                ", MemberName='" + name + '\'' +
                ", MemberLastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(idMember, member.idMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMember);
    }

}