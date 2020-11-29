package com.springmvc.dao;

import com.springmvc.domain.Brand;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //此注解代表这是一个持久层，用法类似@controller、@service
public interface IBrandDao {



    //根据姓名查询品牌,并获取其下所有的商品
    @Select("select *from brand where bname=#{bname}")
    @Results(value={
            @Result(id =true,property = "bid",column = "bid"),
            @Result(property = "bname",column = "bname"),
            @Result(property = "city",column = "city"),
            @Result(property = "introduction",column = "introduction"),
            @Result(property = "Shops",column = "bid",many = @Many(select = "com.springmvc.dao.IShopDao.FindShopByBid"))

    }
    )
    public Brand FindBrand_shop(String bname);

    @Select("select *from brand" )
    public List<Brand> findAll();



}
