package cput.ac.za.controller.users.members;

import cput.ac.za.domain.members.Member;
import cput.ac.za.services.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    @Qualifier("memberServiceImpli")
    private MemberService service;

    @PostMapping(value ="/create" , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Member create(@RequestBody Member member) {
        return service.create(member);
    }

    @PostMapping("/update")
    @ResponseBody
    public Member update(Member member) {
        return service.update(member);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Member read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Member> getAll() {
        return service.getAll();
    }
}
