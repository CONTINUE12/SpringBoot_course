package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {

    /*
    * 属性必须在数据表中存在，下面两个是另一个数据表的属性，所以临时注释掉
    * */
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

    //以是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
