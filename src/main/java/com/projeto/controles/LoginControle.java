package com.projeto.controles;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginControle {

   

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}