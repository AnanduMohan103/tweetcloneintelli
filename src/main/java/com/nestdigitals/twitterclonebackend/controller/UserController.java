package com.nestdigitals.twitterclonebackend.controller;

import com.nestdigitals.twitterclonebackend.dao.UserDao;
import com.nestdigitals.twitterclonebackend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adduser",consumes = "application/json",produces = "application/json")
    public String Adduser(@RequestBody UserModel add){
        System.out.println(add.toString());
        dao.save(add);
        return "{status=success}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewuser")
    public List<UserModel> View(){
        return (List<UserModel>)
                dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginUser",consumes = "application/json",produces = "application/json")
    public List<UserModel> SignIn(@RequestBody UserModel login){
        return (List<UserModel>) dao.Logindata(login.getEmail(), login.getPassword());
    }
}
