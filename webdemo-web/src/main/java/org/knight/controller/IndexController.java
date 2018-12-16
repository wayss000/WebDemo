package org.knight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wayss.
 * @date 2018/12/16.
 */
@Controller
public class IndexController {

    /**
     * Web-Demo首页
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
