package com.springmvc.test;

import com.springmvc.dao.IBrandDao;
import com.springmvc.dao.IShopDao;
import com.springmvc.domain.Brand;
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

public class testbrand {
    private SqlSession session=null;
    private IBrandDao dao=null;
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
            dao=session.getMapper(IBrandDao.class);//
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
    public void FindBrand_shop(){
        if(session!=null){
            Brand emos=dao.FindBrand_shop("小米");
            System.out.println(emos);
        }
    }

}
