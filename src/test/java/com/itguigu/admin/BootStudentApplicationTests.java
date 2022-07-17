package com.itguigu.admin;

import com.itguigu.admin.mapper.UserMapper;
import com.itguigu.admin.pojo.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootTest
@Slf4j
class BootStudentApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user where user_id = 1", Long.class);
       log.info("记录总数{}",aLong);
       log.info("数据源类型{}",dataSource.getClass());
    }

    @Test
    void mybatisPlus(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

}
