package com.chuanmei.movie.mapper;

import com.chuanmei.movie.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository  //声明这个接口是一个数据访问层
public interface AdminMapper {
    // 思路: public  返回值类型   方法名(参数列表);
    public int insert(Admin admin);

    public List<Admin> selectAll();

    public Admin selectAdmin(Admin admin);
}
