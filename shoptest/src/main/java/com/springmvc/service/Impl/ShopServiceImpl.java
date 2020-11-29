package com.springmvc.service.Impl;

import com.springmvc.dao.IShopDao;
import com.springmvc.domain.Shop;
import com.springmvc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Autowired
    private IShopDao iShopdao;

    @Override
    public List<Shop> findAll() {
        System.out.println("service业务层：查询所有用户...");
        return iShopdao.findAll();
    }

    @Override
    public  List<Shop> FindShopByBid(int bid){
        return iShopdao.FindShopByBid(bid);
    }

    @Override
    public Shop FindShopBySid(int sid) {
        return iShopdao.FindShopBySid(sid);
    }

    @Override
    public void insertShop(Shop shop) {
        iShopdao.insertShop(shop);
    }

    @Override
    public void updateShop(Shop shop) {
        iShopdao.updateShop(shop);
    }

    @Override
    public void deleteShopBySid(int sid) {
        iShopdao.deleteShopBySid(sid);
    }


}
