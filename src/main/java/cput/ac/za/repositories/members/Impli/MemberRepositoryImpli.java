package cput.ac.za.repositories.members.Impli;

import cput.ac.za.domain.members.Member;
import cput.ac.za.repositories.members.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("memberRepositoryImpli")
public class MemberRepositoryImpli implements MemberRepository {
    private static MemberRepository memberRepository = null;
    private Set<Member> memberDB;

    private MemberRepositoryImpli() { this.memberDB = new HashSet<>();
    }

    private Member findClass(String memberId) {
        return this.memberDB.stream()
                .filter(member -> member.getIdMember().trim().equals(memberId))
                .findAny()
                .orElse(null);
    }

    public static MemberRepository memberRepository() {
        if (memberRepository == null) memberRepository = new MemberRepositoryImpli();
        return memberRepository;
    }

    @Override
    public Member create(Member member) {
        this.memberDB.add(member);
        return member;
    }


    @Override
    public Member read(String memberId) {
        Member member = findClass(memberId);
        return member;
    }


    @Override
    public Member update(Member member) {
        Member toDelete = findClass(member.getIdMember());
        if(toDelete != null) {
            this.memberDB.remove(toDelete);
            return create(member);
        }
        return null;
    }


    @Override
    public void delete(String memberId) {
        Member member = findClass(memberId);
        if (member != null) this.memberDB.remove(member);
    }


    @Override
    public Set<Member> getAll() {
        return this.memberDB;
    }
}
