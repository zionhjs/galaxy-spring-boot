package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.Video;

import java.util.List;

public interface UploadVideoMapper extends Mapper<Video> {

    List<Video> list(Video video);
}
