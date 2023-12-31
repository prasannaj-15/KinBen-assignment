package com.kinben.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinben.Dto.EmployeeDto;
import com.kinben.Exception.EmployeeException;
import com.kinben.Models.Employee;
import com.kinben.Repository.EmployeeRepository;

@Service
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

	@Override
	public EmployeeDto getEmployee(Integer id) throws EmployeeException {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee not found with ID: " + id));

        return modelMapper.map(employee,EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() throws EmployeeException {
		
        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
	}

    
    
}
