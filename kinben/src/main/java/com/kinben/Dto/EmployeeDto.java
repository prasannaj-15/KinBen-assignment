package com.kinben.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    
    private Integer EmployeeId;

    private String name;

    private String Phone;

    private String email;

    private String address;

    private String education;

    private Integer experience;
    
}
