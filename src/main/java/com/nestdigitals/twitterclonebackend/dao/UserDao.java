package com.nestdigitals.twitterclonebackend.dao;

import com.nestdigitals.twitterclonebackend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {
    @Query(value = "SELECT * FROM `users` WHERE email = :email AND password = :password",nativeQuery = true)
    List<UserModel> Logindata(String email,String password);
}
