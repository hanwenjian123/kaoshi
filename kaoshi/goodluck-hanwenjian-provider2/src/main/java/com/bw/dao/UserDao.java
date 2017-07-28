package com.bw.dao;

import com.bw.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ${hanwenjian} on 2017/7/28.
 */
/*@CacheConfig(cacheNames = "users")*/
public interface UserDao extends JpaRepository<User,Integer> {


    List<User>  findByUname(String uname);
    User findByUnameAndUpwd(String uname,String upwd);
}
