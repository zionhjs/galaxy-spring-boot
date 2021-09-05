package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.MomentComment;


/**
* Created by CodeGenerator on 2020/12/23.
*/
public interface CmsMomentCommentService extends Service<MomentComment> {

    Result add(MomentComment momentComment);

    Result detail(Long id);

    Result list(Integer page, Integer size, MomentComment momentComment);
}
