package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoc_010 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext_10.xml");
		MonBean beanPrototype = applicationContext.getBean(MonBean.class);
		MonBean beanPrototype1 = applicationContext.getBean(MonBean.class);
		System.out.println("Est ce que les deux beans sont les même: "
							+ (beanPrototype == beanPrototype1));
	}

}
