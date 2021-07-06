package com.chuanmei.movie.controller;

import com.chuanmei.movie.pojo.Hall;
import com.chuanmei.movie.pojo.Movie;
import com.chuanmei.movie.service.MovieService;
import com.chuanmei.movie.util.QiniuTool;
import com.chuanmei.movie.util.Result;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.rmi.server.ExportException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    @ResponseBody
    public Result addMovie(@RequestParam("file") MultipartFile file, Movie movie){
        try {
            System.out.println("-----addMovie方法执行了------");
            System.out.println("file = " + file + ", movie = " + movie);
            // 获取上传的file的后缀名
            String last= FilenameUtils.getExtension(file.getOriginalFilename());
            // 新文件名
            String fileName = UUID.randomUUID().toString() + "." + last;
            System.out.println("新文件名 = " + fileName);
            //创建一个目录
            File dir = new File("d:/files");
            if (!dir.exists()) {
                dir.mkdirs(); //创建目录
            }
            file.transferTo(new File(dir, fileName));//将图片存储到本地
            //调用七牛云的工具类（将本地的图片存储到七牛云服务器上）
            String uploadPath = QiniuTool.upload(new File(dir, fileName).getAbsolutePath());
            System.out.println("七牛云服务器上的图片地址=" + uploadPath);
            //把云地址存储到数据库中
            movie.setImg(uploadPath);
        }catch (Exception e){
            e.printStackTrace();
        }
        return movieService.addMovie(movie); //调用service层中的方法
    }



    @RequestMapping("/fenye")
    @ResponseBody
    public Map<String,Object> fenye(int pageNum, int pageSize){
        Map<String,Object> map=new HashMap<>();
        System.out.println("-----请求fenye方法-----");
        System.out.println("pageNum = " + pageNum + ", pageSize = " + pageSize);
        //调用service层的方法
        List<Movie> movieList = movieService.fenye(pageNum, pageSize);
        long totals=movieService.totals();
        map.put("movieList",movieList); //显示的数据
        map.put("pageNum",pageNum);//当前页码
        map.put("pageSize",pageSize);//每页显示的个数
        map.put("totals",totals); //总记录数
        map.put("totalPage",totals%pageSize==0? totals/pageSize : totals/pageSize +1);//总页数
        return map;
    }

}
