package com.itheima.service;

import com.itheima.pojo.Article;
import com.itheima.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    //分页查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
