package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoc_008 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext_08.xml");
		DataBaseProperties beanDataBaseProperties = applicationContext.getBean(DataBaseProperties.class);
		System.out.println(beanDataBaseProperties);
	}

}
