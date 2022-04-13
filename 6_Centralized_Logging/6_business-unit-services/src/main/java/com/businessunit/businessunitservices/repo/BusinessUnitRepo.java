package com.businessunit.businessunitservices.repo;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.businessunit.businessunitservices.entities.BusinessUnitEntitity;

@Repository
@Transactional
public interface BusinessUnitRepo extends JpaRepository<BusinessUnitEntitity, Integer> {

}
