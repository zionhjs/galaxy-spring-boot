package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.BlogImages;

import java.util.List;


/**
* Created by CodeGenerator on 2020/12/27.
*/
public interface CmsBlogImagesService extends Service<BlogImages> {

    Result batch(List<BlogImages> blogImagesList);

    Result deleteByUrl(String url);
}
