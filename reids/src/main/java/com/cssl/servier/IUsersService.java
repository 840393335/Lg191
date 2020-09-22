package com.cssl.servier;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Uname;

import java.util.List;

public interface IUsersService extends IService<Uname> {
        public List<Uname>findUsers();
        public boolean add (Uname d);
        public boolean xg(Uname d);
        public boolean sc(int d);
        public Uname idcx(int sd);
}
