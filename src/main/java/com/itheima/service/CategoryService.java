package com.itheima.service;

import com.itheima.pojo.Category;
import com.itheima.pojo.Result;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    List<Category> list();

    Category findById(Integer id);

    void update(Category category);

    void remove(Integer id);
}
