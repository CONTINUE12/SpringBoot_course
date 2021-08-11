package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString //代替tostring方法
@Data //代替get和set方法
@NoArgsConstructor //无参构造器
@AllArgsConstructor //有参构造器
public class Pet {

    private String name;

}
