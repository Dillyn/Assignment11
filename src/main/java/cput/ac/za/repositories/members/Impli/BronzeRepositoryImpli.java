package cput.ac.za.repositories.members.Impli;

import cput.ac.za.domain.members.Bronze;
import cput.ac.za.repositories.members.BronzeRepository;

import java.util.HashSet;
import java.util.Set;

public class BronzeRepositoryImpli implements BronzeRepository {
    private static BronzeRepository memberRepository = null;
    private Set<Bronze> memberDB;

    private BronzeRepositoryImpli() { this.memberDB = new HashSet<>();
    }

    private Bronze findClass(String memberId) {
        return this.memberDB.stream()
                .filter(member -> member.getIdBronze().trim().equals(memberId))
                .findAny()
                .orElse(null);
    }

    public static BronzeRepository memberRepository() {
        if (memberRepository == null) memberRepository = new BronzeRepositoryImpli();
        return memberRepository;
    }

    @Override
    public Bronze create(Bronze member) {
        this.memberDB.add(member);
        return member;
    }


    @Override
    public Bronze read(String memberId) {
        Bronze member = findClass(memberId);
        return member;
    }


    @Override
    public Bronze update(Bronze member) {
        Bronze toDelete = findClass(member.getIdBronze());
        if(toDelete != null) {
            this.memberDB.remove(toDelete);
            return create(member);
        }
        return null;
    }


    @Override
    public void delete(String memberId) {
        Bronze member = findClass(memberId);
        if (member != null) this.memberDB.remove(member);
    }


    @Override
    public Set<Bronze> getAll() {
        return this.memberDB;
    }
}
