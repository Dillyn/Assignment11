package cput.ac.za.services.members.Impli;

import cput.ac.za.domain.members.Bronze;
import cput.ac.za.repositories.members.BronzeRepository;
import cput.ac.za.repositories.members.Impli.BronzeRepositoryImpli;
import cput.ac.za.services.members.BronzeService;

import java.util.HashSet;
import java.util.Set;

public class BronzeServiceImpli implements BronzeService {

    private BronzeRepository memberRepository;
    private static BronzeService memberService = null;

    private BronzeServiceImpli() {
        this.memberRepository = BronzeRepositoryImpli.memberRepository();
    }

    public BronzeService getBronzeService() {
        if (memberService == null) memberService = new BronzeServiceImpli();
        return memberService;
    }

    @Override
    public Bronze create(Bronze d) {
        return this.memberRepository.create(d);
    }

    @Override
    public Bronze read(String strengthId) {
        return this.memberRepository.read(strengthId);
    }

    @Override
    public Bronze update(Bronze strength) {
        return this.memberRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.memberRepository.delete(strengthId);
    }

    @Override
    public Set<Bronze> getAll() { return this.memberRepository.getAll();
    }
}