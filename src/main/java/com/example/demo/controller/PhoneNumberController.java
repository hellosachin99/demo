package com.example.demo.controller;


import com.example.demo.service.ModifyNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneNumberController {

    @Autowired
    private ModifyNumberService modifyNumberService;

    @GetMapping("/modify/{phone}")
    public ResponseEntity<List<String>> modify(@PathVariable String phone) {
        return new ResponseEntity<>(modifyNumberService.modifyPhoneNumber(phone), HttpStatus.OK);
    }
}
