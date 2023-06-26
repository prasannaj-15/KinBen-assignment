package com.kinben.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinben.Dto.EmployeeDto;
import com.kinben.Exception.EmployeeException;
import com.kinben.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> addEmployee( @RequestBody EmployeeDto employeeDto){

        return new ResponseEntity<EmployeeDto>(employeeService.addEmployee(employeeDto), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<EmployeeDto> updateEmployee( @RequestBody EmployeeDto employeeDto) throws EmployeeException{

        return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(employeeDto), HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/{id}")

    public ResponseEntity<EmployeeDto> deleteEmployee( @PathVariable Integer id) throws EmployeeException{

        return new ResponseEntity<EmployeeDto>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee( @PathVariable Integer id) throws EmployeeException{

        return new ResponseEntity<EmployeeDto>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() throws EmployeeException{
        
        return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

}
