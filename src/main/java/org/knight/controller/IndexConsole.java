package org.knight.controller;

import org.springframework.stereotype.Controller;
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
}
