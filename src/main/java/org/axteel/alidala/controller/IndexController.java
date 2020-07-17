package org.axteel.alidala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping (value = "/users")
    public String getUsers() {
        return "users";
    }
}
