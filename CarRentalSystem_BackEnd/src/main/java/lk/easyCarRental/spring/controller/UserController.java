package lk.easyCarRental.spring.controller;

import lk.easyCarRental.spring.dto.AdminDTO;
import lk.easyCarRental.spring.dto.CustomerDTO;
import lk.easyCarRental.spring.dto.DriverDTO;
import lk.easyCarRental.spring.dto.UserDTO;
import lk.easyCarRental.spring.service.UserService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCustomer(@RequestBody CustomerDTO dto) {
        userService.addCustomer(dto);
        return new ResponseEntity(new ResponseUtil(200, "Customer Saved!", dto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/admin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAdmin(@RequestBody AdminDTO dto) {
        userService.addAdmin(dto);
        return new ResponseEntity(new ResponseUtil(200, "Admin saved!", dto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/driver", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDriver(@RequestBody DriverDTO dto) {
        userService.addDriver(dto);
        return new ResponseEntity(new ResponseUtil(200, "Driver saved!", dto), HttpStatus.CREATED);
    }

    @GetMapping(params = {"email", "password"})
    public ResponseEntity getUser(String email, String password) {
        UserDTO user = userService.getUser(email, password);
        return new ResponseEntity(new ResponseUtil(200, "Done", user), HttpStatus.CREATED);
    }

    @GetMapping(path = "/lastid")
    public ResponseEntity getLastUserId() {
        String lastUserId = userService.getLastUserId();
        return new ResponseEntity(new ResponseUtil(200, "Done", lastUserId), HttpStatus.CREATED);
    }

}
