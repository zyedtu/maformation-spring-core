package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoc_001 {
	public static void main(String[] args) {
		// Créer une instance de la classe ApplicationContext
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
		
		//Récupérer le Bean de type MonBean
		MonBean monBean = applicationContext.getBean(MonBean.class);
		
		// Appeler la méthode
		monBean.helloWord();
	}
}
