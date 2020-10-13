package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainIoc_002 {

	public static void main(String[] args) {
		// Créer une instance de la classe ApplicationContext
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\My_Works\\workspace\\maFormationSpringUdemy\\maformation-spring-ioc\\src\\main\\resources\\appContext.xml");
		
		// Récupérer la classe bean  MonBean
		MonBean monBean = applicationContext.getBean(MonBean.class);
		
		// Appler la méthode
		monBean.helloWord();
	}

}
