package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.Email;

/**
* Created by CodeGenerator on 2021/01/02.
*/
public interface JmsEmailService extends Service<Email> {

    Result sendQuery(String userEmail, String messageInside, String messageOutside);

    Result sendGenerateUrl(String userEmail);
}
