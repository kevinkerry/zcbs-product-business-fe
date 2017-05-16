package com.zcbspay.platform.business.fe.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseMaster {
	
}
