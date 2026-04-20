package com.example.blogbackend.service.impl;

import com.example.blogbackend.entity.Article;
import com.example.blogbackend.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> list() {
        return articleMapper.list();
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.getById(id);
    }

    @Override
    public void add(Article article) {
        articleMapper.insert(article);
    }
}
