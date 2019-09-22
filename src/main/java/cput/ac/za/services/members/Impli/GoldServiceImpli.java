package cput.ac.za.services.members.Impli;

import cput.ac.za.domain.members.Gold;
import cput.ac.za.repositories.members.GoldRepository;
import cput.ac.za.repositories.members.Impli.GoldRepositoryImpli;
import cput.ac.za.services.members.GoldService;

import java.util.HashSet;
import java.util.Set;

public class GoldServiceImpli implements GoldService {

    private GoldRepository memberRepository;
    private static GoldService memberService = null;

    private GoldServiceImpli() {
        this.memberRepository = GoldRepositoryImpli.memberRepository();
    }

    public GoldService getBronzeService() {
        if (memberService == null) memberService = new GoldServiceImpli();
        return memberService;
    }

    @Override
    public Gold create(Gold d) {
        return this.memberRepository.create(d);
    }

    @Override
    public Gold read(String strengthId) {
        return this.memberRepository.read(strengthId);
    }

    @Override
    public Gold update(Gold strength) {
        return this.memberRepository.update(strength);
    }

    @Override
    public void delete(String strengthId) {
        this.memberRepository.delete(strengthId);
    }

    @Override
    public Set<Gold> getAll() { return this.memberRepository.getAll();
    }
}
