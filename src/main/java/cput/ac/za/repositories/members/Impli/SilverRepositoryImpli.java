package cput.ac.za.repositories.members.Impli;

import cput.ac.za.domain.members.Silver;
import cput.ac.za.repositories.members.SilverRepository;

import java.util.HashSet;
import java.util.Set;

public class SilverRepositoryImpli implements SilverRepository {
    private static SilverRepository memberRepository = null;
    private Set<Silver> memberDB;

    private SilverRepositoryImpli() { this.memberDB = new HashSet<>();
    }

    private Silver findClass(String memberId) {
        return this.memberDB.stream()
                .filter(member -> member.getIdSilver().trim().equals(memberId))
                .findAny()
                .orElse(null);
    }

    public static SilverRepository memberRepository() {
        if (memberRepository == null) memberRepository = new SilverRepositoryImpli();
        return memberRepository;
    }

    @Override
    public Silver create(Silver member) {
        this.memberDB.add(member);
        return member;
    }


    @Override
    public Silver read(String memberId) {
        Silver member = findClass(memberId);
        return member;
    }


    @Override
    public Silver update(Silver member) {
        Silver toDelete = findClass(member.getIdSilver());
        if(toDelete != null) {
            this.memberDB.remove(toDelete);
            return create(member);
        }
        return null;
    }


    @Override
    public void delete(String memberId) {
        Silver member = findClass(memberId);
        if (member != null) this.memberDB.remove(member);
    }


    @Override
    public Set<Silver> getAll() {
        return this.memberDB;
    }
}
