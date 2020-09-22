package com.cssl.pojo;


import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Uname implements Serializable {
@TableId
  private long usid;
  private String uname;
  private String upwd;


  public long getUsid() {
    return usid;
  }

  public void setUsid(long usid) {
    this.usid = usid;
  }


  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }


  public String getUpwd() {
    return upwd;
  }

  public void setUpwd(String upwd) {
    this.upwd = upwd;
  }

}
