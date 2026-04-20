package com.example.blogbackend.controller;

import com.example.blogbackend.entity.Article;
import com.example.blogbackend.service.impl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", articleService.list());
        return result;
    }

    @GetMapping("/get/{id}")
    public Map<String, Object> getById(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", articleService.getById(id));
        return result;
    }

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Article article) {
        articleService.add(article);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "添加成功");
        return result;
    }
}
