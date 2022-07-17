package com.itguigu.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itguigu.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    //当接口继承了BaseMapper<>时，就不用手动写crud方法
    //在查询数据时，默认表名为对应数据类名，若不对应， 则在bean对象中设置@TableName
    public User getUserById(String id);

}
