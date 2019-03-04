package cn.dx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class paramController {

    @RequestMapping("/testParam")
    public String paramController(String username,String password){
        System.out.println("================="+username+",=============" +password);
        System.out.println("测试成功");
        return "html/success";
    }
}
