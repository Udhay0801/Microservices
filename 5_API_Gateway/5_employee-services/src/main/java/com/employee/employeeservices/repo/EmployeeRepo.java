package com.employee.employeeservices.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employeeservices.entity.EmployeeEntity;

@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
