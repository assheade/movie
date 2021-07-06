package com.chuanmei.movie.service;

import com.chuanmei.movie.mapper.MovieMapper;
import com.chuanmei.movie.pojo.Movie;
import com.chuanmei.movie.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements  MovieService {

    @Autowired
    private MovieMapper movieMapper; //private 警察  小明;

    @Override
    public Result addMovie(Movie movie) {
        int n= movieMapper.insert(movie);
        return n>0?Result.success("影片添加成功"):Result.fail("影片添加失败");

    }

    @Override
    public List<Movie> fenye(int pageNum, int pageSize) {
        int start=pageSize*(pageNum-1);
        int rows=pageSize;
        return movieMapper.selectByFenye(start,rows);
    }

    @Override
    public long totals() {
        return movieMapper.getTotals();
    }
}
