package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoc_006 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContextBeanTypesNoRef.xml");
		BeanTypesNoRef bean = applicationContext.getBean(BeanTypesNoRef.class);
		System.out.println(bean);
	}

}
