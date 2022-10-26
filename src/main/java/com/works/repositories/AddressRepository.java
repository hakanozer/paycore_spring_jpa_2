package com.works.repositories;

import com.works.entities.Address;
import com.works.projections.IAllAddress;
import com.works.projections.ICustomerAddress;
import com.works.projections.IViewAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select * from ADDRESS as ADDRESS inner join CUSTOMER as C on C.CID = ADDRESS.CUSTOMER_CID", nativeQuery = true)
    Page<List<ICustomerAddress>> allCusAddJoin(Pageable pageable);

    @Query(value = "select * from ADDRESS as ADDRESS inner join CUSTOMER as C on C.CID = ADDRESS.CUSTOMER_CID where lower(TITLE) like %?1% or lower(ADDRESS) like %?2% ", nativeQuery = true)
    Page<List<ICustomerAddress>> allCusAddJoinSearch( String data1, String data2, Pageable pageable);

    Page<List<Address>> findAllByTitleContains(String title, Pageable pageable);

    @Query(value = "select A.AID, A.ADDRESS, A.CITY, A.TITLE from ADDRESS ", nativeQuery = true)
    List<IAllAddress> allAddress();

    Page<List<Address>> findByTitleContainsOrCityContainsAllIgnoreCase(String title, String city, Pageable pageable);

    @Query("select a from Address a where upper(a.customer.name) = upper(?1) and upper(a.customer.cid) = upper(?2)")
    List<Address> findQueryAddress(String name, Long cid);

    // Storge Proccedure Call
    @Query(value = "Call proAllAddress(?1)", nativeQuery = true)
    List<Address> callProAllAddress(String data);

    // View in SQL Call
    @Query(value = "select * from VIEW_ADDRESS", nativeQuery = true)
    List<IViewAddress> allViewAddress();
    

}