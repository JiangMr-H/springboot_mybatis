package com.jiang.controller;

import com.jiang.Entity.UserForJpa;
import com.jiang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins="*",allowCredentials="true")
public class UserForController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/jpaquery")
    @ResponseBody
    public List<UserForJpa> findAll(){
        List<UserForJpa> all = userRepository.findAll();
        return all;
    }


}
