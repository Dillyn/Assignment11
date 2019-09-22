package cput.ac.za.controller.users.staff;

import cput.ac.za.domain.staff.Staff;
import cput.ac.za.factories.staff.StaffFactory;
import cput.ac.za.services.staff.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/api/admin/staff")
public class StaffController {
    @Autowired
    private StaffServices service;

    @PostMapping(value ="/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff createStaff(@RequestBody Staff staff) {
        //Staff staff1 = StaffFactory.getStaff(staff.getIdStaff(), staff.getName(), staff.getLastName(), staff.getTitle());
        return service.create(staff);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public Staff update(@RequestBody Staff staff) {
        return service.update(staff);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Staff read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Staff> getAll() {
        return service.getAll();
    }
}
