package fr.bouteraa.zied.maformation_spring_ioc;

import org.springframework.beans.factory.InitializingBean;

public class MonService_014 implements InitializingBean{

	public MonService_014() {
		System.out.println("constructeur");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Je suis le méthode afterPropertiesSet de la classe MonService_014");
	}
}
