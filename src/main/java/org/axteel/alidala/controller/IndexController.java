package org.axteel.alidala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

}
