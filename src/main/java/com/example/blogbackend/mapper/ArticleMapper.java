package com.example.blogbackend.mapper;

import com.example.blogbackend.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
//mybatis接口，定义数据库要做什么（查列表、按ID查、新增）
@Mapper
public interface ArticleMapper {
    List<Article> list();//要查询所有文章
    Article getById(Integer id);//要按ID查询一篇文章
    void insert(Article article);//要新增一篇文章


    // 新加
    void update(Article article);
    void deleteById(Integer id);
}
//mybatis根据唯一id去XML里找到对应的SQL