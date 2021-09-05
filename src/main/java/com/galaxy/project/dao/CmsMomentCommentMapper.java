package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.MomentComment;

import java.util.List;

public interface CmsMomentCommentMapper extends Mapper<MomentComment> {

    List<MomentComment> selectMomentCommentByBlogId(Long momentId);

    MomentComment detail(Long id);

    List<MomentComment> list(MomentComment momentComment);
}