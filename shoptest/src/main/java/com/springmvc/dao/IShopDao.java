package com.springmvc.dao;


import com.springmvc.domain.Shop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShopDao {

    //查询所有商品
    @Select("select *from shop")
    public List<Shop> findAll();

    //通过品牌id查询所有商品
    @Select("select *from shop where bid=#{bid}")
    public List<Shop> FindShopByBid(int bid);

    //通过商品id查询所有商品
    @Select("select *from shop where sid=#{sid}")
    public Shop FindShopBySid(int sid);

    //添加一条商品
    @Insert("insert into shop value (#{sid},#{sname},#{num},#{price},#{pic},#{bid})")
    public void insertShop(Shop shop);

    //修改一条商品
    @Update("update shop set sname=#{sname},num=#{num},price=#{price},pic=#{pic},bid=#{bid} WHERE sid=${sid}")
    public void updateShop(Shop shop);

    //删除一条商品
    @Delete("delete from shop where sid=#{sid}")
    public void deleteShopBySid(int sid);



}
