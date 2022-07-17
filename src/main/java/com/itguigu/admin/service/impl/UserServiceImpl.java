package com.itguigu.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itguigu.admin.mapper.UserMapper;
import com.itguigu.admin.pojo.User;
import com.itguigu.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//采用实现了UserService，但是重写其中Iservice的方法过于麻烦，
// 可通过继承extends Service<M extends BaseMapper<T>, T>
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(String id){
        User user = userMapper.getUserById(id);
        System.out.println("--------------"+user);
        return user;
    }

}
