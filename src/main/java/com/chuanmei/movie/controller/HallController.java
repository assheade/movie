package com.chuanmei.movie.controller;

import com.chuanmei.movie.pojo.Hall;
import com.chuanmei.movie.service.HallService;
import com.chuanmei.movie.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hall")
public class HallController {

    @Autowired
    private HallService hallService;

    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Hall hall){
        System.out.println("------检测addHall方法是否执行了------");
        System.out.println("hall = " + hall);//检测值是否获取到了
        return hallService.addHall(hall);
    }

    @RequestMapping("/checkHallName")
    @ResponseBody
    public Result checkHallName(String name){
        System.out.println("------检测checkHallName方法是否执行了------");
        System.out.println("name = " + name);//检测值是否获取到了
        return hallService.checkHallName(name);
    }

    @RequestMapping("/fenye")
    @ResponseBody
    public Map<String,Object> fenye(int pageNum,int pageSize){
        Map<String,Object> map=new HashMap<>();
        System.out.println("-----请求fenye方法-----");
        System.out.println("pageNum = " + pageNum + ", pageSize = " + pageSize);
        //调用service层的方法
        List<Hall> hallList = hallService.fenye(pageNum, pageSize);
        long totals=hallService.totals();
        map.put("hallList",hallList); //显示的数据
        map.put("pageNum",pageNum);//当前页码
        map.put("pageSize",pageSize);//每页显示的个数
        map.put("totals",hallService.totals()); //总记录数
        map.put("totalPage",totals%pageSize==0? totals/pageSize : totals/pageSize +1);//总页数
        return map;
    }
}
