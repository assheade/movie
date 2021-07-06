package com.chuanmei.movie.service;


import com.chuanmei.movie.pojo.Admin;
import com.chuanmei.movie.util.Result;

public interface AdminService {

    public Result<Admin> addAdmin(Admin admin);

    public Result adminList();

    public Result login(Admin admin);
}
