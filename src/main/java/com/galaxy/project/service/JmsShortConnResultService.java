package com.galaxy.project.service;

import com.galaxy.project.core.Service;
import com.galaxy.project.model.ShortConnResult;

/**
* Created by CodeGenerator on 2021/01/04.
*/
public interface JmsShortConnResultService extends Service<ShortConnResult> {

    ShortConnResult getByUrl(String url);
}
