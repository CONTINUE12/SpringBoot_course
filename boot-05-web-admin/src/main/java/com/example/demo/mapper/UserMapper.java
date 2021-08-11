package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.User;

//继承basemapper类后，基本的数据库crud操作方法都可以直接使用
public interface UserMapper extends BaseMapper<User> {

}
