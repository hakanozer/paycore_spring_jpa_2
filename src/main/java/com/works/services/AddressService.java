package com.works.services;

import com.works.entities.Address;
import com.works.projections.ICustomerAddress;
import com.works.projections.IViewAddress;
import com.works.repositories.AddressRepository;
import com.works.repositories.J_CusAddRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        Sort sort = Sort.by("CUSTOMER_CID").descending();
        Pageable pageable = PageRequest.of(page, 2, sort );
        Page<List<ICustomerAddress>> list = aRepo.allCusAddJoin(pageable);
        hm.put(REnum.result, list );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    // search
    public ResponseEntity search( String q, int page, String sorting) {
        Map<REnum, Object> hm = new LinkedHashMap<>();

        Sort sort = Sort.by("aid").ascending();
        if ( sorting.equals("city_asc") ) {
            sort = Sort.by("city").ascending();
        }else if ( sorting.equals("city_desc") ) {
            sort = Sort.by("city").descending();
        }
        q = q.toLowerCase();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<List<ICustomerAddress>> list = aRepo.allCusAddJoinSearch(q, q, pageable );
        //Page<List<Address>> list = aRepo.findByTitleContainsOrCityContainsAllIgnoreCase(q,q,pageable);

        hm.put(REnum.status, true);
        hm.put(REnum.result, list );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    // JPA Query Search
    public ResponseEntity querySearch( String name, Long cid ) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        List<Address> list = aRepo.findQueryAddress(name, cid);
        hm.put(REnum.status, true);
        hm.put(REnum.result, list );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    // View Call
    public ResponseEntity viewCall() {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        List<IViewAddress> list = aRepo.allViewAddress();
        hm.put(REnum.status, true);
        hm.put(REnum.result, list );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
