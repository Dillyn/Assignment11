package cput.ac.za.security;

import cput.ac.za.domain.members.Member;
import cput.ac.za.factories.members.MemberFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.RootUriRequestExpectationManager;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GymSecurityTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/api/member";



    @Before
    public void addDummyData(){

       // Member member = MemberFactory.getClasss("1","Dillyn", "Lakey");

        //ResponseEntity<Member> postResponse = restTemplate.postForEntity(baseURL + "/create", member, Member.class);

    }



    @Test
    public void createMember() {
        Member member = MemberFactory.getClasss("1","Dillyn", "Lakey");
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(baseURL + "/create", member, Member.class);
        System.out.println(result.getBody());
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAll() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("user", "password")
                .getForEntity(baseURL + "/read/all", String.class);
        System.out.println(result.getBody());
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}