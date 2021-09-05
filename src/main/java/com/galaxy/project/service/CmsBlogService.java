package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.Blog;

/**
* Created by CodeGenerator on 2020/12/23.
*/
public interface CmsBlogService extends Service<Blog> {

    Result detail(Long id);

    Result list(Integer page, Integer size, Blog blog);

    Result homeFindByTitle(Integer page, Integer size, String title);

    Result add(Blog blog);

    Result updateBlog(Blog blog);

    Result findByModalOrderByTime(Integer page, Integer size, Blog blog);
}
