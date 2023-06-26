package com.kinben.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    

    @GetMapping("/admin/signin")
    public ResponseEntity<String> login(Authentication auth){
        return ResponseEntity.ok("Login Successfull");
    }

}

