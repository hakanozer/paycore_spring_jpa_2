package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerRestController {

    final CustomerService cService;

    @PostMapping("add")
    public ResponseEntity add( @RequestBody Customer customer) {
        return cService.save(customer);
    }

}
