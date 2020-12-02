package fr.bouteraa.zied.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.bouteraa.zied.dao.FormationDao;
import fr.bouteraa.zied.dao.FormationDaoImpl;

@Configuration
@ComponentScan("fr.bouteraa.zied.service")
public class Configuration016 {

	@Bean
	public FormationDao formationDao() {
		return new FormationDaoImpl();
	}
}
