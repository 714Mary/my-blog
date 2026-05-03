package com.example.blogbackend.service.impl;

import com.example.blogbackend.entity.Article;
import com.example.blogbackend.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//业务真正实现，调用Mapper，完成实际逻辑。Controller调用Service接口时，实际跑这个实现类
@Service//告诉Spring，这是业务类，交给容器管理
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;//自动注入Mapper,不用new，spring帮你创建对象

    @Override
    public List<Article> list() {
        return articleMapper.list();
    }//直接调用 Mapper方法，触发XML里的SQL

    @Override
    public Article getById(Integer id) {
        return articleMapper.getById(id);
    }

    @Override
    public void add(Article article) {
        articleMapper.insert(article);
    }

    // 新加 ↓↓↓
    @Override
    public void update(Article article) {
        articleMapper.update(article);
    }

    @Override
    public void deleteById(Integer id) {
        articleMapper.deleteById(id);
    }

}
