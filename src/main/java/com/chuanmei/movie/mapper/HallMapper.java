package com.chuanmei.movie.mapper;

import com.chuanmei.movie.pojo.Hall;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HallMapper {
    public int insert(Hall hall);

    public long selectByName(String name);

    public List<Hall> selectByPage(@Param("start") int start,@Param("rows") int rows);

    public long getTotals();

}
