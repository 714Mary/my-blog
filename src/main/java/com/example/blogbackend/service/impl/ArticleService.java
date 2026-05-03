package com.example.blogbackend.service.impl; // 必须和实现类在同一个包

import com.example.blogbackend.entity.Article;
import java.util.List;
//业务接口，定义业务能做什么，和mapper一一对应，代码就是把mapper的方法再暴露一层。Controller只负责接收请求，业务逻辑必须放Service，这是Java后端规范
public interface ArticleService {
    List<Article> list();
    Article getById(Integer id);
    void add(Article article);
    // 新加
    void update(Article article);
    void deleteById(Integer id);
}
