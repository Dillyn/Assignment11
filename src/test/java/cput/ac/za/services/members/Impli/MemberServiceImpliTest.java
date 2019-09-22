package cput.ac.za.services.members.Impli;

import cput.ac.za.domain.members.Member;
import cput.ac.za.factories.members.MemberFactory;
import cput.ac.za.repositories.members.Impli.MemberRepositoryImpli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceImpliTest {

    private MemberRepositoryImpli repository;
    private Member member;

    private Member getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (MemberRepositoryImpli) MemberRepositoryImpli.memberRepository();
        this.member = MemberFactory.getClasss("1","Dillyn", "Lakey");
    }

    @Test
    public void a_create() {
        Member created = this.repository.create(this.member);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.member);
    }

    @Test
    public void c_update() {

        String name = "class";

        Member updated = new Member.Builder().copy(getSaved()).name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void e_delete() {
        Member saved = getSaved();
        this.repository.delete(saved.getIdMember());
        d_getAll();
    }

    @Test
    public void b_read() {
        Member saved = getSaved();
        Member read = this.repository.read(saved.getIdMember());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Member> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}