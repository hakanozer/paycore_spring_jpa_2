package com.works.repositories;

import com.works.entities.J_CusAdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface J_CusAddRepository extends JpaRepository<J_CusAdd, Long> {

    @Query(value = "select A.AID, A.ADDRESS, A.CITY, A.TITLE, C.CID, C.NAME, C.SURNAME, C.PHONE\n" +
            "from ADDRESS A inner join CUSTOMER C on C.CID = A.CUSTOMER_CID", nativeQuery = true)
    List<J_CusAdd> allJoin();
}