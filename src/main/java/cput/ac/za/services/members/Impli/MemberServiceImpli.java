package cput.ac.za.services.members.Impli;

import cput.ac.za.domain.members.Member;
import cput.ac.za.repositories.members.Impli.MemberRepositoryImpli;
import cput.ac.za.repositories.members.MemberRepository;
import cput.ac.za.services.members.MemberService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("memberServiceImpli")
public class MemberServiceImpli implements MemberService {

    private MemberRepository memberRepository;
    private static MemberService memberService = null;

    private MemberServiceImpli() {
        this.memberRepository = MemberRepositoryImpli.memberRepository();
    }

    public MemberService getMemberService() {
        if (memberService == null) memberService = new MemberServiceImpli();
        return memberService;
    }

    @Override
    public Member create(Member d) {
        return this.memberRepository.create(d);
    }

    @Override
    public Member read(String strengthId) {
        return this.memberRepository.read(strengthId);
    }

    @Override
    public Member update(Member strength) {
        return this.memberRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.memberRepository.delete(strengthId);
    }

    @Override
    public Set<Member> getAll() { return this.memberRepository.getAll();
    }
}

