package com.chuanmei.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int id;
    private String name;
    private String img;
    private String description;
    private String director;
    private String writer;
    private String actor;
    private String type;
    private String area;
    private String language;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showtime;
    private String length;
    private float grade;
    private String link;
    private int status;// 0上映  1 下架
}
