package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository cRepo;

    public ResponseEntity save(Customer customer) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        Optional<Customer> optionalCustomer = cRepo.findByEmailEquals(customer.getEmail());

        try {
            if ( optionalCustomer.isPresent() ) {
                throw new RuntimeException("");
            }
            cRepo.save(customer);
            hm.put(REnum.status, true);
            hm.put(REnum.result, customer);
        }catch (Exception ex) {
            hm.put(REnum.status, false);
            hm.put(REnum.message, "email address all ready use");
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
