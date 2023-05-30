package org.accekll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ExitController {
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        System.out.println(session.getAttribute("user"));
        session.removeAttribute("user");
        System.out.println(session.getAttribute("user"));
        return "redirect:/login.html";
    }
}
