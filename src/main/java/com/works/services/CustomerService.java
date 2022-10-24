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

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository cRepo;

    public ResponseEntity save(Customer customer) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        cRepo.save(customer);
        hm.put(REnum.status, true);
        hm.put(REnum.result, customer);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
