package com.example.simple_form.controller;
import com.example.simple_form.model.usersmodel;
import com.example.simple_form.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class userscontroller {
    @Autowired
    private userservice userservice;
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new usersmodel());
        return "register";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginrequest",new usersmodel());
        return "login";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute usersmodel usersmodel)
    {
System.out.println("register request:"+usersmodel );
usersmodel registereduser=userservice.registeruser(usersmodel.getLogin(), usersmodel.getEmail(), usersmodel.getPassword());
return registereduser!=null?"redirect:/login":"error";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute usersmodel usersmodel,Model model)
    {
        System.out.println("login request:"+usersmodel );
        usersmodel authenticated=userservice.authenticate(usersmodel.getLogin(), usersmodel.getPassword());
        System.out.println(authenticated);
        if(authenticated!=null){
            model.addAttribute("userlogin",authenticated.getLogin());
            return "personalpg";

        }
        else{
            return "error";
        }
    }


}
