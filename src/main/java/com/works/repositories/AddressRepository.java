package com.works.repositories;

import com.works.entities.Address;
import com.works.projections.IAllAddress;
import com.works.projections.ICustomerAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select * from ADDRESS as ADDRESS inner join CUSTOMER as C on C.CID = ADDRESS.CUSTOMER_CID", nativeQuery = true)
    Page<List<ICustomerAddress>> allCusAddJoin(Pageable pageable);

    Page<List<Address>> findAllByTitleContains(String title, Pageable pageable);

    @Query(value = "select A.AID, A.ADDRESS, A.CITY, A.TITLE from ADDRESS ", nativeQuery = true)
    List<IAllAddress> allAddress();

}