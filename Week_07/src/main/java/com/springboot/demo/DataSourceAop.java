package com.springboot.demo;



import com.springboot.demo.util.DBContexHolder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DataSourceAop {

    @Before("execution(* com.springboot.demo.service.*(..))")
    public void before(JoinPoint point){
        String method=point.getSignature().getName();
        if(StringUtils.startsWithAny(method,new String[]{"get","select","query"})){
            DBContexHolder.setSlave();
        }else{
            DBContexHolder.setMaster();
        }
    }
}
