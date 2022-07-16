package com.itguigu.admin.controller;

import com.itguigu.admin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user where user_id = 1", Long.class);
        return aLong.toString();
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String main(User user, Model model, HttpSession session){
//      在此不能使用redirect:main，因为使用redirect时就不调用模板引擎
//      当控制器方法中所设置的视图名称以"forward:"为前缀时，
//      创建InternalResourceView视图，此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，
//      而是会将前缀"forward:"去掉，剩余部分作为最终路径通过转发的方式实现跳转
//      重定向视图在解析时，会先将redirect:前缀去掉，然后会判断剩余部分是否以/开头，若是则会自动拼接上下文路径

        /**
         * 判断其是否为空，不为空则重定向
         * 登录成功重定向到main.html
         */
        System.out.println("user = " + user);
        if(StringUtils.hasLength(user.getUsername())&&StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("LoginUser", user);
            return "redirect:/main.html";
        }
        model.addAttribute("msg","账号不能为空！");
        return "login";
    }

    /**
     * 在此不可以直接访问main,templates文件夹下是存放模板，必须使用模板引擎才能访问
     * 在此.html只是访问路径，起到标识作用，方便自己理解
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //是否登录成功 采用拦截器过滤器，在此为了方便采用session
//        Object LoginUser = session.getAttribute("LoginUser");
//        if(LoginUser != null){
//            return "main";
//        }
//        else{
//            model.addAttribute("msg","账号密码错误");
//            return "login";
//        }
        return "main";

    }
}
