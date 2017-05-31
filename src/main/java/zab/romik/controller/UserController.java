package zab.romik.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by ROMIK on 29.05.2017.
 */
public class UserController {

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @PostMapping("/userForm")
    public String addUser(){
       return "userForm";
    }


    }
