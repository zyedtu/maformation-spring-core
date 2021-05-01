package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoc_003 {

	public static void main(String[] args) {
		// Créer une instance de la classe ApplicationContext
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContextAware.xml");
		
		// On donne un nom à notre application contexte
		applicationContext.setDisplayName("Mon Application Context");
		
		// Récupérer le Bean de type MonBean
		MonBeanAware monBeanAware = applicationContext.getBean(MonBeanAware.class);

		// Appeler la méthode
		monBeanAware.helloWord();

	}
}
}
