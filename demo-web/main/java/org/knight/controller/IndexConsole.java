package org.knight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wayss
 * @date 2018/3/28
 */
@Controller
public class IndexConsole {

    @RequestMapping(value = "/jsp")
    public String jsp() {
        System.out.println("jsp");
        return "jsp";
    }

    @RequestMapping(value = "/html")
    public String html() {
        System.out.println("html");
        return "html";
    }

    @RequestMapping(value = "velocity")
    public String velocity(Model model){
        System.out.println("velocity");

        String name = "wayss";
        model.addAttribute("name", name);

        return "hello";
    }

}
