package com.kinben.Service;

import com.kinben.Dto.EmployeeDto;
import com.kinben.Exception.EmployeeException;

public interface EmployeeService {


    public EmployeeDto addEmployee(EmployeeDto employeeDto);

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeException;

    public EmployeeDto deleteEmployee(Integer id) throws EmployeeException;
    
}
