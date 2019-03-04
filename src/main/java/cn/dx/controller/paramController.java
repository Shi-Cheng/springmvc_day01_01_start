package cn.dx.controller;

import cn.dx.domain.Account;
import cn.dx.domain.Person;
import cn.dx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class paramController {

    @Autowired
    private static User user;

    @Autowired
    private static Account account;
    /**
     * 请求参数绑定
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/testParam")
    public String paramController(String username,String password){
        System.out.println("================="+username+",=============" +password);
        System.out.println("测试成功");
        return "html/success";
    }
    /**
     * 请求参数绑定把数据封装到JavaBean中类中
     * @return
     */
    @RequestMapping(value = "/saveAccount",method = RequestMethod.POST)
    public  ModelAndView saveAccount(Account account){
        System.out.println("===========" + account.getUsername());
        System.out.println("===========" + account.getMoney());
        System.out.println("============"+account.getUser());
        System.out.println("============"+account.getUser());
        //得到user中具体的name 和age account.getUser().getUname() 和 account.getUser().getUname()
        System.out.println("============"+account.getUser().getUname());
        System.out.println("测试成功");
        return new ModelAndView("redirect:/html/success.html");
    }
    @RequestMapping("/savePerson")
    public ModelAndView savePerson(Person person){
        System.out.println(person);
        System.out.println(person.getDate());
        System.out.println("测试成功");
        return new ModelAndView("redirect:/html/success.html");
    }
}
