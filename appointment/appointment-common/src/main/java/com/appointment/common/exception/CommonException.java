package com.appointment.common.exception;

import com.appointment.common.entity.ResultCode;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义异常
 */
@Getter
public class CommonException extends Exception  {

    private ResultCode resultCode;

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
