package com.springmvc.service;

import com.springmvc.domain.Shop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShopService {

    public List<Shop> findAll();

    public  List<Shop> FindShopByBid(int bid);

    public  Shop FindShopBySid(int sid);

    public void insertShop(Shop shop);

    public void updateShop(Shop shop);

    public void deleteShopBySid(int sid);


}
