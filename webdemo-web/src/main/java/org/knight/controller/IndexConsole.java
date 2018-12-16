package org.knight.controller;

import org.knight.model.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "velocity/list")
    public String velocityList(Model model){

        List<People> peoples = new ArrayList<People>();

        People people1 = new People();
        people1.setAge(18);
        people1.setName("zhangsan");
        peoples.add(people1);

        People people2 = new People();
        people2.setAge(19);
        people2.setName("李四");
        peoples.add(people2);

        People people3 = new People();
        people3.setAge(20);
        people3.setName("王五");
        peoples.add(people3);

        model.addAttribute("peoples", peoples);
        return "foreach";
    }

    @RequestMapping("returnjson")
    @ResponseBody
    public People returnJson(){
        People people = new People();
        people.setAge(18);
        people.setName("张三");
        return people;
    }

}
