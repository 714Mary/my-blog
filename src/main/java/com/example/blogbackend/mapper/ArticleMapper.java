package com.example.blogbackend.mapper;

import com.example.blogbackend.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> list();
    Article getById(Integer id);
    void insert(Article article);
}
