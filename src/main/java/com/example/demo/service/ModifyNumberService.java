package com.example.demo.service;

import com.example.demo.exception.InvalidNumberException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ModifyNumberService {
    private static final String Character = "ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvwxyz";

    public List<String> modifyPhoneNumber(String phone) {
        List<String> test = new ArrayList<>();
        StringUtils.trimWhitespace(phone);
        if (!StringUtils.isEmpty(phone) && Pattern.matches("^[0-9]{7,10}$", phone)) {
            for (int i = 0; test.isEmpty() || i < Character.length(); i++) {
                for (int j = i + 1; j < Character.length() && j >= i; j++) {
                    test.add(phone + Character.substring(i, j));
                }
            }
        } else {
            throw new InvalidNumberException("Invalid Number!!");
        }
        return test;
    }

}
