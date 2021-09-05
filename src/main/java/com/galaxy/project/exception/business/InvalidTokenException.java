package com.galaxy.project.exception.business;

import com.galaxy.project.core.ResultCode;
import com.galaxy.project.core.ServiceException;

public class InvalidTokenException extends ServiceException {
    /**
     *
     */
    private static final long serialVersionUID = 8867783841194312911L;

    public ResultCode getCode() {
        return ResultCode.NOT_EXIST_TOKEN_EXCEPTION;
    }

    public String getErrorMessage() {
        return String.format("不存在得token");
    }

}
