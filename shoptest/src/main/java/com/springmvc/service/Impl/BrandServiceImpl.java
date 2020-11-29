package com.springmvc.service.Impl;

import com.springmvc.dao.IBrandDao;
import com.springmvc.domain.Brand;
import com.springmvc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    private IBrandDao iBrandDao;


    @Override
    public Brand FindBrand_shop(String bname) {

        return iBrandDao.FindBrand_shop(bname);
    }

    @Override
    public List<Brand> findAll(){
        return iBrandDao.findAll();
    }
}
