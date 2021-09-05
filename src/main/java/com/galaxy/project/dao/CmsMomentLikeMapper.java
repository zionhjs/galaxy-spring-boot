package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.MomentLike;
import org.apache.ibatis.annotations.Param;

public interface CmsMomentLikeMapper extends Mapper<MomentLike> {

    Integer findMomentLikeById(MomentLike momentLike);

    Integer updateBlogMomentLikeById(@Param("subjectId") Long subjectId, @Param("num") int num);

    Integer updateMomentCommentLikeById(@Param("subjectId") Long subjectId, @Param("num") int num);

    MomentLike selectByIdAndIsDelete(@Param("subjectId") Long subjectId, @Param("createBy") String createBy);

    Integer updateLike(MomentLike momentLike);
}