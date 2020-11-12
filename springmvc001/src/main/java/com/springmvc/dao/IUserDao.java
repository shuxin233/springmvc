package com.springmvc.dao;



import com.springmvc.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository  //此注解代表这是一个持久层，用法类似@controller、@service
public interface IUserDao {
    @Select("select *from user")
    public List<User> findAll();

}
