package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoc_014 {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:appContext_14.xml");
		applicationContext.close();

	}

}

