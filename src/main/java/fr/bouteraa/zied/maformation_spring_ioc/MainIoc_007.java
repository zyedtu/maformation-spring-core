package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.bouteraa.zied.service.FormationService;

public class MainIoc_007 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext_07.xml");
		FormationService fs = applicationContext.getBean(FormationService.class);
//		FormationService fs = (FormationService) applicationContext.getBean("formationService");
		fs.findAll();

	}

}
