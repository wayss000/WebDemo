package org.knight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wayss.
 * @date 2018/8/1.
 */
@Controller
public class TestHttpMethod {

    @RequestMapping("testHttpMethod")
    public String testHttpMethod(){

        return "httprequest";
    }


//    @RequestMapping(value = "testget", method = RequestMethod.GET)
    @RequestMapping("testget")
    public String testGet(HttpServletRequest request){

        String parm1 = request.getParameter("parm1");
        System.out.println("parm1:" + parm1);

        String parm2 = request.getParameter("parm2");
        System.out.println("parm2:" + parm2);

        return "httprequest";
    }

//    @RequestMapping(value = "testpost", method = RequestMethod.POST)
    @RequestMapping("testpost")
    public String testPost(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println("name:" + name);

        String age = request.getParameter("age");
        System.out.println("age:" + age);

        return "httprequest";
    }

//    @RequestMapping(value = "testput", method = RequestMethod.PUT)
    @RequestMapping("testput")
    public String testPut(HttpServletRequest request){

        System.out.println("testput");
        return "httprequest";
    }

//    @RequestMapping(value = "testdelete", method = RequestMethod.DELETE)
    @RequestMapping("testdelete")
    public String testDelete(HttpServletRequest request){

        System.out.println("testdelete");
        return "httprequest";
    }


}
