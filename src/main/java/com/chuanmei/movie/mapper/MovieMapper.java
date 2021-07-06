package com.chuanmei.movie.mapper;

import com.chuanmei.movie.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieMapper {

    public int insert(Movie movie);

    public List<Movie> selectByFenye(@Param("start")int start, @Param("rows")int rows);

    public long getTotals();

}

