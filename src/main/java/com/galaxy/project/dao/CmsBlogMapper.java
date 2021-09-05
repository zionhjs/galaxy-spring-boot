package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.Blog;

import java.util.List;

public interface CmsBlogMapper extends Mapper<Blog> {

    Blog detail(Long id);

    void updateBlogBrowseNum(Long id);

    List<Blog> list(Blog blog);

    Integer getBlogCountById(Long id);

    List<Blog> findByModalOrderByTime(Blog blog);
}