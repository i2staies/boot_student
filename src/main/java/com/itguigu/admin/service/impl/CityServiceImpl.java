package com.itguigu.admin.service.impl;

import com.itguigu.admin.mapper.CityMapper;
import com.itguigu.admin.pojo.City;
import com.itguigu.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    public City getCityById(String id){
        return cityMapper.getCityById(id);
    }

    public int saveCity(City city){
        return cityMapper.insertCity(city);
    }
}
