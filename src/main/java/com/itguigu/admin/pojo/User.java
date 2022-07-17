package com.itguigu.admin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("user_tb")
public class User {

//    所有属性都应该在数据库中
//    @TableField(exist = false) 代表在数据库中不存在
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

//    以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
