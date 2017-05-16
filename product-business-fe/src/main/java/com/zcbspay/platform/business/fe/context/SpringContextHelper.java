package com.zcbspay.platform.business.fe.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHelper implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}
