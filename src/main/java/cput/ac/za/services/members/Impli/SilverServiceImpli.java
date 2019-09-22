package cput.ac.za.services.members.Impli;

import cput.ac.za.domain.members.Silver;
import cput.ac.za.repositories.members.Impli.SilverRepositoryImpli;
import cput.ac.za.repositories.members.SilverRepository;
import cput.ac.za.services.members.SilverService;

import java.util.HashSet;
import java.util.Set;

public class SilverServiceImpli implements SilverService {

    private SilverRepository memberRepository;
    private static SilverService memberService = null;

    private SilverServiceImpli() {
        this.memberRepository = SilverRepositoryImpli.memberRepository();
    }

    public SilverService getSilverService() {
        if (memberService == null) memberService = new SilverServiceImpli();
        return memberService;
    }

    @Override
    public Silver create(Silver d) {
        return this.memberRepository.create(d);
    }

    @Override
    public Silver read(String strengthId) {
        return this.memberRepository.read(strengthId);
    }

    @Override
    public Silver update(Silver strength) {
        return this.memberRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.memberRepository.delete(strengthId);
    }

    @Override
    public Set<Silver> getAll() { return this.memberRepository.getAll();
    }
}
