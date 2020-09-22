package com.cssl.servier.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.UsersDao;
import com.cssl.pojo.Uname;
import com.cssl.servier.IUsersService;
import com.cssl.util.RedisConfig;
import com.cssl.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UsersService extends ServiceImpl<UsersDao, Uname>implements IUsersService {
    @Autowired
    private RedisUtil util;

    @Override
    public List<Uname> findUsers() {
        List<Uname> list = null;
        if (util.exists("list1")) {
            list = (List<Uname>) util.get("list1");
        } else {
            System.out.println("not exists..");
            list = super.list();
            util.set("list1", list,10L);
        }
        return list;
    }
    @CachePut(value = "user",key = "#d.usid")
    @Override
    public boolean add(Uname d) {
        util.remove("list1");
        boolean  qqe = super.save(d);
        return  qqe;
    }
    @CacheEvict(value = "user",key = "#d")
    @Override
    public boolean sc(int d) {
        util.remove("list1");
        System.out.println("id"+d);
        boolean q=super.removeById(d);
        return  q;
    }
    @Cacheable(value="user", key="#sd")
    @Override
    public Uname idcx(int sd) {
        System.out.println("sddd"+sd);
        Uname q=super.getById(sd);
        return q;
    }

    @CachePut(value = "user", key="#d.usid")
    @Override
    public boolean xg(Uname d) {
        util.remove("list1");
        boolean q=true;
        q=super.updateById(d);
        return  q;
    }

}





