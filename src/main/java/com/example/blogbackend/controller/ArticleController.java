package com.example.blogbackend.controller;

import com.example.blogbackend.common.Result;
import com.example.blogbackend.entity.Article;
import com.example.blogbackend.service.impl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 查询列表
    @GetMapping("/list")
    public Result<List<Article>> list() {
        return Result.success(articleService.list());
    }

    // 根据ID查询
    @GetMapping("/get/{id}")
    public Result<Article> getById(@PathVariable Integer id) {
        return Result.success(articleService.getById(id));
    }

    // 新增
    @PostMapping("/add")
    public Result<?> add(@RequestBody Article article) {
        articleService.add(article);
        return Result.success();
    }

    // ==================== 下面是新增的 ====================
    // 修改
    @PutMapping("/update")
    public Result<?> update(@RequestBody Article article) {
        articleService.update(article);
        return Result.success();
    }

    // 删除
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        articleService.deleteById(id);
        return Result.success();
    }
}