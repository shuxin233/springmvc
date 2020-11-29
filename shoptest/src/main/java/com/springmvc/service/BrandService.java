package com.springmvc.service;

import com.springmvc.domain.Brand;

import java.util.List;

public interface BrandService {

    public Brand FindBrand_shop(String bname);

    public List<Brand> findAll();
}
