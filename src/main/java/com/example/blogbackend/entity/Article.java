package com.example.blogbackend.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createTime;//对应数据库create_time,因为开启了驼峰自动映射
}
