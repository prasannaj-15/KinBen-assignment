package com.kinben.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AdminController {
    

    @GetMapping("/admin/signin")
    public ResponseEntity<String> login(Authentication auth){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authToken = authentication.getCredentials().toString();

        System.out.println("Something");
        System.out.println(authToken);


        return ResponseEntity.ok("Login Successfull");
    }

}

