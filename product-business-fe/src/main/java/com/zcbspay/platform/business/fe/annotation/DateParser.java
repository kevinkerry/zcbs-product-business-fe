package com.zcbspay.platform.business.fe.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateParser {
//名称
String name() default "";
//格式化
String pattern() default "yyyy-MM-dd hh:mm:ss";
}