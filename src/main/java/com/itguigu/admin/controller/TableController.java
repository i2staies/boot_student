package com.itguigu.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itguigu.admin.pojo.User;
import com.itguigu.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;


    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model, @RequestParam(value = "pn",defaultValue = "1")Long pn){
//        List<User> users = Arrays.asList(new User("zhangsan", "zhangsan"),
//                new User("lisi", "lisi"),
//                new User("wangwu", "wangwu"),
//                new User("zhaoliu", "zhaoliu"));

//      获取所以User对象
        List<User> list = userService.list();
        model.addAttribute("users", list);

//        分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
//        分页查询的结果
        Page<User> page = userService.page(userPage, null);

        model.addAttribute("page", page);
        return "table/dynamic_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/user/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")String id){
        userService.removeById(id);
        return "redirect:/dynamic_table";
    }
}
