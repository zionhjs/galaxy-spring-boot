package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.BlogImages;

import java.util.List;

public interface CmsBlogImagesMapper extends Mapper<BlogImages> {

    List<BlogImages> selectBlogImagesByBlogId(Long blogId);

    void batchDeleteBlogImages(Long blogId);

    void deleteByUrl(String url);
}