package com.galaxy.project.exception.business;

import com.galaxy.project.core.ResultCode;
import com.galaxy.project.core.ServiceException;

/**
 * @Author chenjinming
 * @ClassName OutTimeToken
 * @Description TOOD
 * @Date 2019/9/18 15:39
 **/
public class OutTimeToken extends ServiceException {
    private static final long serialVersionUID = -7051836414685780479L;

    public ResultCode getCode() {
        return ResultCode.OUT_TIME_TOKEN;
    }

    public String getErrorMessage() {
        //应该使用统一异常
        return "登录超时，请重新登录";
    }
}
