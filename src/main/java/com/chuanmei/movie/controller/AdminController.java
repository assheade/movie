package com.chuanmei.movie.controller;

import com.chuanmei.movie.pojo.Admin;
import com.chuanmei.movie.service.AdminService;
import com.chuanmei.movie.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //声明这个类是一个控制器
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;  //依赖注入业务逻辑层   private 警察  小明;
    // @RequestBody 页面传递的json格式的数据 转换成 admin对象
    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody Admin admin){
        System.out.println("login请求成功");
        System.out.println("admin = " + admin); //soutp
        return adminService.login(admin); //鼠标定位到login,按下alt+enter,创建这个方法
    }


    @RequestMapping("/adminList")
    @ResponseBody
    public Result adminList(){
        System.out.println("-----adminList请求成功-----");
        return adminService.adminList();//因为没有定义这个方法，alt+enter创建这个方法
    }

    @RequestMapping("/add")
    @ResponseBody //直接将Result对象传递给页面
    public Result addAdmin(Admin admin){
        System.out.println("-----addAdmin方法请求成功-----");
        System.out.println("admin = " + admin); //测试参数是否获取成功
        return  adminService.addAdmin(admin); //将结果返回给页面
    }
}
