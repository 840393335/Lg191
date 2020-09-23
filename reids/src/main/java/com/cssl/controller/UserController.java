package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.pojo.Uname;
import com.cssl.servier.impl.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UsersService service;
    @RequestMapping("/find")
    public String find(Model d){
        List<Uname>q=service.findUsers();
        d.addAttribute("q",q);
        return  "page";
    }
    @PostMapping("/add")
    public String ss(  String uname,  String upd){
        Uname qq=new Uname();
        qq.setUname(uname);
        qq.setUpwd(upd);
        service.add(qq);
        return  "redirect:/find";
    }
    @ResponseBody
    @PostMapping("/sc")
    public int sc(int sid){
        boolean q=service.sc(sid);
        int num=0;
        if (q==true){
            num=1;
        }else {
            num=2;
        }
        return  num;
    }

   @GetMapping("/xg")
    public String xg( int sid,Model d){
        Uname qq=service.idcx(sid);
        d.addAttribute("q",qq);
        return  "Update";
   }
    @PostMapping("/up")
    public String upq(Uname d){
        System.out.println(d.getUname());
        System.out.println(d.getUpwd());
        boolean q=service.xg(d);

        return  "redirect:/find";
   }
}
