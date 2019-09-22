package cput.ac.za.repositories.members.Impli;

import cput.ac.za.domain.members.Gold;
import cput.ac.za.repositories.members.GoldRepository;

import java.util.HashSet;
import java.util.Set;

public class GoldRepositoryImpli implements GoldRepository {
    private static GoldRepository memberRepository = null;
    private Set<Gold> memberDB;

    private GoldRepositoryImpli() { this.memberDB = new HashSet<>();
    }

    private Gold findClass(String memberId) {
        return this.memberDB.stream()
                .filter(member -> member.getIdGold().trim().equals(memberId))
                .findAny()
                .orElse(null);
    }

    public static GoldRepository memberRepository() {
        if (memberRepository == null) memberRepository = new GoldRepositoryImpli();
        return memberRepository;
    }

    @Override
    public Gold create(Gold member) {
        this.memberDB.add(member);
        return member;
    }


    @Override
    public Gold read(String memberId) {
        Gold member = findClass(memberId);
        return member;
    }


    @Override
    public Gold update(Gold member) {
        Gold toDelete = findClass(member.getIdGold());
        if(toDelete != null) {
            this.memberDB.remove(toDelete);
            return create(member);
        }
        return null;
    }


    @Override
    public void delete(String memberId) {
        Gold member = findClass(memberId);
        if (member != null) this.memberDB.remove(member);
    }


    @Override
    public Set<Gold> getAll() {
        return this.memberDB;
    }
}
