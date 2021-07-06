package com.chuanmei.movie.service;

import com.chuanmei.movie.pojo.Movie;
import com.chuanmei.movie.util.Result;

import java.util.List;

public interface MovieService {

    public Result addMovie(Movie movie);

    public List<Movie> fenye(int pageNum, int pageSize);

    public long totals();

}
