package com.kinben.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kinben.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
