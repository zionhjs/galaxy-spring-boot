package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.MomentLike;


/**
* Created by CodeGenerator on 2020/12/23.
*/
public interface CmsMomentLikeService extends Service<MomentLike> {

    Result add(MomentLike momentLike);

    Result updateLike(MomentLike momentLike);
}
