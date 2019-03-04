package cn.dx.controller;

import cn.dx.domain.Account;
import cn.dx.domain.Person;
import cn.dx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/first")
@SessionAttributes(value = {"username","password","age"},types = {String.class,Integer.class})
public class paramController {

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

    @RequestMapping("/testServelet")
    public String testServelet(HttpServletRequest request,HttpServletResponse response){
        System.out.println("执行了....");
        System.out.println(request);

        HttpSession session = request.getSession();
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        System.out.println();
        return "html/success";
    }

    /**
     * modelAttribute 有参返回类型
     * @return
     */
    @ModelAttribute
    public User showUser(){
        System.out.println("showUser 方法执行了...");
        User user = new User();
        user.setUname("王小六");
        user.setAge(13);
        return user;
    }
    /**
     * 输出user
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        System.out.println(user);
        return "html/success";
    }


    @ModelAttribute
    public void showVoidUser(String name, Map<String,User> map){
        User user = new User();
        user.setUname("小琪");
        user.setAge(12);
        map.put("abc",user);
    }
    /**
     * modelAttribute 无返回传值  通过键值对的方式获取对应的字段
     * @param user
     * @return
     */
    @RequestMapping("/updateVoidUser")
    public String updateVoidUser(@ModelAttribute(value = "abc") User user){
        System.out.println(user);
        return "html/success";
    }

    @RequestMapping("/saveSessionAttribute")
    public String SaveSessionAttribute(Model model){
        System.out.println("向session中存入值");
        model.addAttribute("username","张三");
        model.addAttribute("password","12345");
        model.addAttribute("age",20);

        return "html/success";
    }

    @RequestMapping("/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelMap){
        System.out.println("ModelMap 方法执行了...");
        String username = (String) modelMap.get("username");
        String password = (String) modelMap.get("password");
        Integer age = (Integer) modelMap.get("age");

        System.out.println("============"+username+", "+password + ", "+ age);
        return "html/success";
    }

}
