package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.Images;

import java.util.List;

public interface UploadImagesMapper extends Mapper<Images> {

    Images getImagesDetailsById(Long id);

    List<Images> list(Images images);
}
