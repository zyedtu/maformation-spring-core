package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MonBeanAware implements ApplicationContextAware{

private ApplicationContext appCtx;
	
	public void helloWord() {
		System.out.println("Hello Word from [ " + appCtx.getDisplayName() + " ]");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appCtx = applicationContext;
	}
}
