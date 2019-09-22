package cput.ac.za.repositories.members.Impli;

import cput.ac.za.domain.members.Member;
import cput.ac.za.factories.members.MemberFactory;
import cput.ac.za.repositories.members.MemberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MemberRepositoryImpliTest {

    private MemberRepository repository;
    private Member member;

    private Member getSavedClass() {
        Set<Member> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = MemberRepositoryImpli.memberRepository();
        this.member = MemberFactory.getClasss("1","Dillyn", "Lakey");
    }

    @Test
    public void a_create() {
        Member created = this.repository.create(this.member);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.member);
    }

    @Test
    public void b_read() {
        Member savedMember = getSavedClass();
        System.out.println("In read, genderId = "+ savedMember.getIdMember());
        Member read = this.repository.read(savedMember.getIdMember());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedMember, read);
    }

    @Test
    public void e_delete() {
        Member savedGender = getSavedClass();
        this.repository.delete(savedGender.getIdMember());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Member member = new Member.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + member);
        Member updated = this.repository.update(member);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Member> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}