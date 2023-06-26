package com.kinben.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.kinben.Dto.EmployeeDto;
import com.kinben.Exception.EmployeeException;
import com.kinben.Models.Employee;
import com.kinben.Repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        return modelMapper.map(employeeRepository.save(employee),EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeException {
        
        Employee employee = employeeRepository.findById(employeeDto.getEmployeeId()).orElseThrow(() -> new EmployeeException("Employee not found with ID: " + employeeDto.getEmployeeId()));

        employee = employeeRepository.save(modelMapper.map(employeeDto, Employee.class));

        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto deleteEmployee(Integer id) throws EmployeeException {
        
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee not found with ID: " + id));

        employeeRepository.delete(employee);

        return modelMapper.map(employee,EmployeeDto.class);
    }
    
}
