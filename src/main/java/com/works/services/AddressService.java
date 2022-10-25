package com.works.services;

import com.works.entities.Address;
import com.works.projections.ICustomerAddress;
import com.works.repositories.AddressRepository;
import com.works.repositories.J_CusAddRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AddressService {

    final AddressRepository aRepo;
    final J_CusAddRepository cRepo;

    public ResponseEntity add(Address address) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        hm.put(REnum.result, aRepo.save( address ));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(int page) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        //List<J_CusAdd> list = cRepo.allJoin();
        Pageable pageable = PageRequest.of(page, 2 );
        Page<List<ICustomerAddress>> list = aRepo.allCusAddJoin(pageable);
        hm.put(REnum.result, list );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
