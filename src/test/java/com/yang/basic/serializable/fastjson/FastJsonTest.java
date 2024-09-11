package com.yang.basic.serializable.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yang.basic.serializable.fastjson.Person;
import com.yang.basic.serializable.fastjson.ResultVO;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FastJsonTest {
    /**
     * 序列化把bean转化为json字符串
     */
    @Test
    public void test1(){
        Person person = new Person();
        person.setId(1L);
        //person.setName("张三");
        person.setPwd("123456");
        person.setAddr("北京市故宫博物馆");
        person.setWebsiteUrl("www.theForbiddenCity.com.cn");
        person.setRegisterDate(new Date());
        person.setBirthDay(LocalDateTime.now());

        //序列化 使用SerializerFeature.WriteMapNullValue包含空值
        System.out.println(JSON.toJSONString(person, SerializerFeature.WriteMapNullValue));

        //时间格式有问题，则在bean文件属性上面加上注解@JSONField(format = "yyyy-MM-dd HH:mm:ss")

        //美化格式输出 一般不用
        System.out.println(JSON.toJSONString(person, true));

        /*
        存在的问题：
        1.包含null，如果某个变量没有设置初始值，则不会该属性不会被序列化
        2.日期时间格式化
        3.奇怪的"$ref"
        4.SerializeFilter定制处理（对属性或者属性值在序列化之前做定制处理）
         */
    }

    /**
     * fastjson的引用探测
     * $ref:对象中多次引用了同一个其他对象，序列化就会出现$ref
     */
    @Test
    public void test2$ref(){
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        list.add(person);
        list.add(person);
        list.add(person);

        //SerializerFeature.DisableCircularReferenceDetect 禁用引用探测功能
        String s = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(s);
        //[{"addr":null,"birthDay":null,"id":1,"name":"张三","pwd":null,"registerDate":null,"websiteUrl":null},{"$ref":"$[0]"},{"$ref":"$[0]"}]
    }

    /**
     * serializeFilter
     * 输出的json字符串的key是大写的
     */
    @Test
    public void testSerializeFilter(){
        Person person = new Person();
        person.setId(1L);
        //person.setName("张三");
        person.setPwd("123456");
        person.setAddr("北京市故宫博物馆");
        person.setWebsiteUrl("www.theForbiddenCity.com.cn");
        person.setRegisterDate(new Date());
        person.setBirthDay(LocalDateTime.now());

        NameFilter nameFilter = (object, name, value) -> {
            return name.toUpperCase();
        };

        String s = JSON.toJSONString(person, nameFilter);
        System.out.println(s);
    }

    /**
     * 反序列化
     */
    @Test
    public void testDeSerialize(){
        String jsonStr = "{\"addr\":\"北京市故宫博物馆\"," +
                "\"birthDay\":\"2022-05-09 20:33:26\"," +
                "\"id\":1," +
                "\"name\":null," +
                "\"pwd\":\"123456\"," +
                "\"registerDate\":\"2022-05-09 20:33:26\"," +
                "\"websiteUrl\":\"www.theForbiddenCity.com.cn\"}";

        Person person = JSON.parseObject(jsonStr, Person.class);
        System.out.println(person);

        /*
        存在的问题，泛型处理
         */
        ResultVO<Person> resultVO = ResultVO.buildSuccess(person);
        String voJsonStr = JSON.toJSONString(resultVO, SerializerFeature.WriteMapNullValue);
        System.out.println(voJsonStr);

        //这种在反序列化后，不能获取到泛型类型，需要强转
        /*ResultVO resultVO1 = JSON.parseObject(voJsonStr, ResultVO.class);
        System.out.println(resultVO1);*/

        ResultVO<Person> resultVO2 = JSON.parseObject(voJsonStr, new TypeReference<ResultVO<Person>>() {});
        System.out.println(resultVO2);
        System.out.println(resultVO2.getData());
    }
}
