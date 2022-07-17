package com.itguigu.admin.mapper;

import com.itguigu.admin.pojo.City;
import jdk.nashorn.internal.objects.annotations.Optimistic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("select * from city where id = #{id}")
    public City getCityById(String id);

//    @Insert("insert into city(name,state,country) values (#{name},#{state},#{country})")
//    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int insertCity(City city);
}
