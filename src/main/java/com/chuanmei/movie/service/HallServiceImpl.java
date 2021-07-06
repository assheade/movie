package com.chuanmei.movie.service;

import com.chuanmei.movie.mapper.HallMapper;
import com.chuanmei.movie.pojo.Hall;
import com.chuanmei.movie.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired //自动装配
    private HallMapper hallMapper; //private 警察  小明;

    @Override
    public Result addHall(Hall hall) {
        int n = hallMapper.insert(hall);
        return n>0?Result.success("影厅添加成功"):Result.fail("影厅添加失败");
    }

    @Override
    public Result checkHallName(String name) {
        long n= hallMapper.selectByName(name);
        if(n==1){
            return Result.fail("已经存在，不可以使用!");
        }else{
            return Result.success("可以使用");
        }
    }

    @Override
    public List<Hall> fenye(int pageNum, int pageSize) {
        int start = pageSize * (pageNum-1);
        int rows = pageSize;
        List<Hall> hallList= hallMapper.selectByPage(start,rows);
        return hallList;
    }

    @Override
    public long totals() {
        return hallMapper.getTotals();
    }


}
