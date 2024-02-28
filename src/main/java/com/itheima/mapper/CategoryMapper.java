package com.itheima.mapper;

import com.itheima.pojo.Category;
import com.itheima.pojo.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) " +
            "values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    @Select("select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);

    @Select("select * from category where id=#{id}")
    Category findById(Integer id);


    @Update("update category set category_name=#{categoryName},category.category_alias=#{categoryAlias},update_time=#{updateTime} where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id=#{id}")
    void remove(Integer id);
}
