/** 
 * Project Name:wm-common 
 * File Name:GlobalExceptionHandler.java 
 * Package Name:org.github.ycg000344.weiming.common.handle 
 * Date:2018年5月6日下午5:52:24 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.common.base.handle;

import javax.servlet.http.HttpServletResponse;

import org.github.ycg000344.weiming.common.base.constants.CommonConstants;
import org.github.ycg000344.weiming.common.base.exception.BaseException;
import org.github.ycg000344.weiming.common.base.vo.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:GlobalExceptionHandler <br/><br/>  
 * Description: 全局异常处理类 <br/><br/>  
 * Date:     2018年5月6日 下午5:52:24 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        log.error(ex.getMessage(),ex);
        return new BaseResponse(ex.getErrorCode(), ex.getErrorMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex) {
    	log.error(ex.getMessage(),ex);
        return new BaseResponse(CommonConstants.EX_OTHER_CODE, ex.getMessage());
    }

}
  