package com.kinben.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinben.Models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
