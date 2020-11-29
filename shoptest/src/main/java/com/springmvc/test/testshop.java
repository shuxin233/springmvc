package com.springmvc.test;

import com.springmvc.dao.IShopDao;
import com.springmvc.domain.Shop;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testshop {
    private SqlSession session=null;
    private IShopDao dao=null;
    @Before //测试方法之前要执行的方法
    public void init(){
        InputStream ins= null;
        try {
            //获取Mybatis的数据库的链接的配置文件
            ins = Resources.getResourceAsStream("SqlMapConfig.xml");
            //视同Mybatis的链接工厂SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
            //获取数据库的链接 SqlSession
            session = factory.openSession();
            dao=session.getMapper(IShopDao.class);//
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void destory(){
        if(session!=null){
            session.commit();
            session.close();
        }
    }


    @Test
    public void selectShopAll() throws Exception{
        if(session!=null){
            List<Shop> emos=dao.FindShopByBid(101);
            for(Shop temp:emos){
                System.out.println(temp);
            }
        }
    }


    @Test
    public void selectShopBySid() throws Exception{
        if(session!=null){
          Shop emos=dao.FindShopBySid(1001);
            System.out.println(emos);
        }
    }


    @Test
    public void insertShop() throws Exception{
        if(session!=null){
            Shop shop=new Shop(1010,"小米16",20,2999,"aaaa",101);
            dao.insertShop(shop);
        }
    }

    @Test
    public void updateShop() throws Exception{
        if(session!=null){
            Shop shop=new Shop(1011,"小米6",20,2999,"aaaa",101);
            dao.updateShop(shop);
        }
    }



    @Test
    public void deleteShopBSid() throws Exception{
        if(session!=null){
            dao.deleteShopBySid(1010);
        }
    }

}
