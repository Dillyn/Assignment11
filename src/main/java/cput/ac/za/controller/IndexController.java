package cput.ac.za.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping(value = {"/"})
    @ResponseBody
    public ResponseEntity<String> getHome() {
        return new ResponseEntity<>("Welcome234 to Payroll App!", HttpStatus.OK);
    }
}
