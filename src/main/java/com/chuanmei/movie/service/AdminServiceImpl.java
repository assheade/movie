package com.chuanmei.movie.service;

import com.chuanmei.movie.mapper.AdminMapper;
import com.chuanmei.movie.pojo.Admin;
import com.chuanmei.movie.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service //声明这个类是一个业务逻辑层
public class AdminServiceImpl implements AdminService{  //鼠标定位到AdminService按下alt+enter
    //依赖于数据访问层mapper
    @Autowired
    private AdminMapper adminMapper;  // private 警察  小明;
    @Override
    public Result adminList() {
        List<Admin> list=adminMapper.selectAll();//alt+enter在AdminMapper中创建这个方法
        return Result.success("查询成功",list);
    }

    @Override
    public Result login(Admin admin) {
        Admin loginAdmin=adminMapper.selectAdmin(admin);//鼠标定位方法上按alt+enter
        System.out.println("从数据库中查询出来的对象:"+loginAdmin);
        if(Objects.nonNull(loginAdmin)){
            return Result.success("登录成功",loginAdmin);
        }else {
            return Result.fail("用户名或者密码错误!");
        }
    }


    @Override
    public Result<Admin> addAdmin(Admin admin) {
        //调用存储到数据库的方法
        int n = adminMapper.insert(admin);// 小明.抓小偷();
        if(n>0){
            return Result.success("插入成功");
        }else{
            return Result.fail("插入失败");
        }
    }

}
