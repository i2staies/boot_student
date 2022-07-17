package com.itguigu.admin.service;

import com.itguigu.admin.pojo.City;

public interface CityService {
    public City getCityById(String id);

    public int saveCity(City city);
}
