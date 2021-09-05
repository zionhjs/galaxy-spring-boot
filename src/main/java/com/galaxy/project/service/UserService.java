package com.galaxy.project.service;
import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.User;
import com.galaxy.project.vo.LoginVo;


/**
* Created by CodeGenerator on 2021/04/16.
*/
public interface UserService extends Service<User> {

    Result logout(Long userId);

    Result login(LoginVo vo);

    Result captcha();

    Result add(User user);

    Result updateUser(User user);

    Result list(Long id);
}
