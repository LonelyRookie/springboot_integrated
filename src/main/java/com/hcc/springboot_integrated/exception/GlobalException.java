package com.hcc.springboot_integrated.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局处理异常
 *
 * @ClassName GlobalException
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/8 18:58
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullPointerExceptionHandler(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e.toString());
        mv.setViewName("error2");
        return mv;
    }
}
