package com.yang.basic.serializable.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Person {
    private Long id;
    private String name;
    // @JSONField(serialize = false, deserialize = false) //该注解的意思是不对这个属性进行序列化和反序列化
    private String pwd;
    private String addr;
    private String websiteUrl; //个人网站地址
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDay;
}
