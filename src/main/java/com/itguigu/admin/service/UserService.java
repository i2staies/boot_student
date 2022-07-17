package com.itguigu.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itguigu.admin.mapper.UserMapper;
import com.itguigu.admin.pojo.User;

import java.util.List;

//可以简化sevice调用mapper，因为mapper中已经 extends BaseMapper<User>
//所以无法直接调用，可以采用继承 IService<T>
public interface UserService extends IService<User> {

    public User getUserById(String id);


}
