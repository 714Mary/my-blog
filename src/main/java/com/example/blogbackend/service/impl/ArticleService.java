package com.example.blogbackend.service.impl; // 必须和实现类在同一个包

import com.example.blogbackend.entity.Article;
import java.util.List;

public interface ArticleService {
    List<Article> list();
    Article getById(Integer id);
    void add(Article article);
}
