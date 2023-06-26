package com.kinben.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kinben.Dto.EmployeeDto;
import com.kinben.Exception.EmployeeException;

@Service
public interface EmployeeService {


    public EmployeeDto addEmployee(EmployeeDto employeeDto);

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeException;

    public EmployeeDto deleteEmployee(Integer id) throws EmployeeException;

    public EmployeeDto getEmployee(Integer id) throws EmployeeException;

    public List<EmployeeDto> getAllEmployee() throws EmployeeException;
    
}
