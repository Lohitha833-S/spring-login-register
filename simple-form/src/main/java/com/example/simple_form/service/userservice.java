package com.example.simple_form.service;

import com.example.simple_form.model.usersmodel;
import com.example.simple_form.repository.Userrepository;
import org.springframework.stereotype.Service;

@Service
public class userservice {
    private final Userrepository userrepository;

    public userservice(Userrepository userrepository) {
        this.userrepository = userrepository;
    }

    public usersmodel registeruser(String login, String email,String password){
     if(login!=null && email!=null && password!=null)
     {
        usersmodel usersmodel = new usersmodel();
        usersmodel.setLogin(login);
         usersmodel.setEmail(email);
        usersmodel.setPassword(password);

        return userrepository.save(usersmodel);
     }
     else {
return null;
     }
     }
     public usersmodel authenticate(String login,String password){
         return userrepository.findByLoginAndPassword(login,password).orElse(null);
     }

}
