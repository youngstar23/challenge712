package com.yang.basic.serializable.jackson;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JacksonTest {

    private final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static ObjectMapper objectMapper = new ObjectMapper(); //ObjectMapper是线程安全的

    static {
        /**
         * 序列化的配置
         */
        //这种方式是全局配置， 如果只需要配置哪个类，则在该类外面加上注解@JsonInclude(JsonInclude.Include.NON_NULL)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //局部配置，如果只需要配置哪个类，就在该类外面加上@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        //objectMapper.findAndRegisterModules();

        //全部配置
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        objectMapper.registerModule(javaTimeModule);
    }

    /**
     * 序列化
     */
    @Test
    public void test1() throws JsonProcessingException {
        User user = new User();
        user.setId(1L);
        //person.setName("张三");
        user.setPwd("123456");
        user.setAddr("北京市故宫博物馆");
        user.setWebsiteUrl("www.theForbiddenCity.com.cn");
        user.setRegisterDate(new Date());
        user.setBirthDay(LocalDateTime.now());

        String s = objectMapper.writeValueAsString(user);
        System.out.println(s);
    }

    /*
    https://www.bilibili.com/video/BV1sP4y1s79X?p=6&spm_id_from=pageDriver
     */
}
