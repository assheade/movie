package com.chuanmei.movie.service;

import com.chuanmei.movie.pojo.Hall;
import com.chuanmei.movie.util.Result;

import java.util.List;

public interface HallService {
    public Result addHall(Hall hall);

    public Result checkHallName(String name);

    public List<Hall> fenye(int pageNum, int pageSize);

    public long totals();
}
