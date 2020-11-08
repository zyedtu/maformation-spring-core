
										SPRING CORE
										
Un **Bean:**   est une instance de classe gérée dans un conteneur de Spring.  
### Spring ApplicationContext:
L'interface ApplicationContext, propose 3 implementations:   
* **ClassPathXmlApplicationContext**: qui charge la definition du context à partir d'un fichier xml continu dans la class Path (voir code MainIoc_001).    
* **FileSystemXmlApplicationContext**: qui charge la definition du context à partir d'un fichier xml continu sur le file system (voir code MainIoc_002).  
* **AnnotationConfigApplicationContext**:  todo  

Pour accéder à une référance du contexte d'application de spring depuis la classe de notre bean, il faut implementer l'interface **ApplicationContextAware** (voir code MainIoc_003). 

### Inversion de controle (Ioc):   
Est un designe pattern dans le processus définit les dependances d'un objet sans avoir à le créer.   
L'inversion de controle est assuré avec *deux opérations*:  
* la recherche de dépendances.  
* L'injection de dépendances.  

L'injection de dépendances peut etre effectuée via le constructeur ou via le modificateur(ou les setteurs).  

###### Injection par constructeur en XML: (voir MainIoc_004)
 
On a déclaré un Bean Dao formationDao, après on declare un deuxièm Bean formationService qui a un constructeur avec deux arguments, le premier une réferance sur un autre bean spring et le deuxième une valeur string.  

	<!-- 	DAO Bean -->
	<bean id="formationDao" class="fr.bouteraa.zied.dao.FormationDaoImpl"></bean>
	
	<!-- 	Service bean -->
	<bean id="formationService" class="fr.bouteraa.zied.service.FormationServiceImpl">
		<constructor-arg ref="formationDao"></constructor-arg>
		<constructor-arg value="Zied"></constructor-arg>
	</bean>
Pour faciliter l'injection par constructeur, Spring propsose un schema, il s'appelle schema **c**:  
pour cela on ajoute le schema:

	xmlns:c="http://www.springframework.org/schema/c"
et on modifie le bean service, en respectant la nomanclature, nomArgumet si le type primitif 
et nomArgument-ref si le type est une reference sur une bean.  

	<bean id="formationService" class="fr.bouteraa.zied.service.FormationServiceImpl"
		c:formationDao-ref="formationDao" c:etablissement="Zied">
	</bean>   
###### Injection par setter en XML: (voir MainIoc_005) 
 
Dans notre exemple on declare deux setters un avec un argument formationDao et le deuxième etablissement.

	<bean id="formationDao" class="fr.bouteraa.zied.dao.FormationDaoImpl"></bean>
	
	<bean id="formationService" class="fr.bouteraa.zied.service.FormationServiceImpl">
		<property name="formationDao" ref="formationDao"></property>
		<property name="etablissement" value="Zied"></property>
	</bean>
Pour faciliter l'injection par setter, Spring propsose un schema, il s'appelle schema **p**:  
pour cela on ajoute le schema:  

	xmlns:p="http://www.springframework.org/schema/p"
et on modifie le bean service, en respectant la nomanclature, nomArgumet si le type primitif 
et nomArgument-ref si le type est une reference sur une bean.  

	<bean id="formationService" class="fr.bouteraa.zied.service.FormationServiceImpl" 
		p:formationDao-ref="formationDao" p:etablissement="Zied">
	</bean>  

Pour spring, tous les dependances qui ne sont pas une référence sur un bean elle se charge lui meme de faire
la convension en bean. (voir MainIoc_006).

###### Injection par constructeur vs injection par setter:  

L'injection par constructeur définit un contrat fort, c'est à un bean doit etre instancié avec toutes ces dépendances meme faculatatives, par contra l'injection par sette est la méthode recomander par ce que elle laisse tout la souplesse necessaire pour les dependances obtionneles.  

###### Autowiring: (Injection automatique):

L'injection explicite des dependences implique plusieurs lignes dans le fichiers de configuration.  
L'autowiring permet de simplifier le fichier de configuration.  
L'autowiring ne s'applique que sur les **objets**, c'est à dire on ne peut injecter automatiquement des primitifs.  
L'autowiring peut fonctionner selon plusieurs stratégies:  
* autodetect: cette stratégie était depreciée depuis la version 3 de Spring. 
* no: TODO 
* byName: TODO
* byType: TODO
* constructor: TODO 

### Les Règles de nommage des beans:  

TODO   

### l'ecture d'un fichier properties & Utilisation de namespaces:   (MainIoc_008)    
    
Pour lire un fichier properties il suffit de crée un fichier sur src/main/resources *database.properties* on met dedans des clé=valeur:  

	driverClassName=org.postgresql.Driver
	url=jdbc:postgresql://localhost:5432/maBase
	userName=user
	password=user  
 En suite on configure le fichier de configuration xml de Spring comme ci dessous:  

	<?xml version="1.0" encoding="UTF-8"?>
	<beans  default-autowire="byName"  xmlns="http://www.springframework.org/schema/beans"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xsi:schemaLocation="
	        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	        
		<!-- Lire un fichier properties en utlisant la balise bean -->
		<bean class= "org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
			<property name="location" value="classpath:database.properties"></property>
		</bean>
		
		<bean class="fr.bouteraa.zied.maformation_spring_ioc.DataBaseProperties">
		<property name="driverClassName" value="${driverClassName}"></property>
		<property name="url" value="${url}"></property>
		<property name="userName" value="${userName}"></property>
		<property name="password" value="${password}"></property>
		</bean>
	</beans>

à la fin en teste avec la classe main MainIoc_008, le plus dure dans cet exemple et d'apprendre le nom de la classe : *org.springframework.beans.factory.config.PropertyPlaceholderConfigurer*   

Spring propose plusieurs espace de nomage ce qu'on l'appelle le *namespaces*, le but de ces derniers, namespaces est de reduire le quantité du code à produire dans le fichier de configuration XML 

pour cela on ajoute le *xml namespaces (xmlns)*: 

	xmlns:context="http://www.springframework.org/schema/context
Notre fichier de configuration de spring devient:

	<?xml version="1.0" encoding="UTF-8"?>
	<beans  default-autowire="byName"  xmlns="http://www.springframework.org/schema/beans"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xmlns:context="http://www.springframework.org/schema/context"
	    xsi:schemaLocation="
	      http://www.springframework.org/schema/beans 
	      http://www.springframework.org/schema/beans/spring-beans.xsd 
	      http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context.xsd">
		
		<!-- Lire un fichier properties en utilisant le namespace context -->
		<context:property-placeholder location="classpath:database.properties"/>
		<bean class="fr.bouteraa.zied.maformation_spring_ioc.DataBaseProperties">
		
		<property name="driverClassName" value="${driverClassName}"></property>
		<property name="url" value="${url}"></property>
		<property name="userName" value="${userName}"></property>
		<property name="password" value="${password}"></property>
		</bean>
	</beans>

### Héritage dans spring:  

Spring permet l'heriatge en fait il utilise la notion du bean abstract *abstract="true"*:  

	<!-- beans here -->
	<bean id="formationDao" class="fr.bouteraa.zied.dao.FormationDaoImpl"></bean>
	<bean id="serviceTemplate" abstract="true">
		<property name="formationDao" ref="formationDao"></property>
	</bean>
	<bean id="formateurService"
		class="fr.bouteraa.zied..service.FormateurServiceImpl" parent="serviceTemplate">
	</bean>
	<bean id="formationService"
		class="fr.bouteraa.zied.service.FormationServiceImpl" parent="serviceTemplate">
		<property name="etablissement" value="zaroumia"></property>
	</bean>

### Création d'un prototype: (MainIoc_010)  

Quand Spring instance des beans, il crée une seule instance de chaque bean (un Singleton), au moins 
que ce comportement soit modifier, ceci est possible via l'attribut **scope** de la balise bean.
Les valeurs possibles de l'attribut scope:     
* Singleton: par defaut   
* Prototype: avec prototype chaque fois que l'instance de bean est demandée le conteneur léger va 
créer une nouvelle instance.  

	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xsi:schemaLocation="
	        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
		<bean id="monBean" class="fr.bouteraa.zied.maformation_spring_ioc.MonBean"></bean>
	</beans>  
La classe de test:  pour un attribut scope par défaut (Singleton)
 
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext_10.xml");
		MonBean beanSingleton = applicationContext.getBean(MonBean.class);
		MonBean beanSingleton1 = applicationContext.getBean(MonBean.class);
		System.out.println("Est ce que les deux beans sont les même: "
							+ (beanSingleton == beanSingleton1));
							
Résultat est: 

	Est ce que les deux beans sont les même: true
	
Pour activer le scope prototype, on ajoute ça dans la balise bean *scope="prototype"*:    

	<bean id="monBean" class="fr.bouteraa.zied.maformation_spring_ioc.MonBean" scope="prototype"></bean>
	
Classe de test: pour un attribut scope prototype  

	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext_10.xml");
		MonBean beanPrototype = applicationContext.getBean(MonBean.class);
		MonBean beanPrototype1 = applicationContext.getBean(MonBean.class);
		System.out.println("Est ce que les deux beans sont les même: "
							+ (beanPrototype == beanPrototype1));
Résultat est:

	Est ce que les deux beans sont les même: false

### Cycle de vie d'un bean: (MainIoc_014) Configuration XML

Le cycle de vie d'un bean spring est résumé en 6 étapes:  
	-	le Chargement de définitions XML/Java  
	-	Instantiation des beans  
	-	Injection des dependances   
	-	Initialisation  
	-	Pret à l'emploi   
	-	Destruction  

On crée deux bean MonBean_014 et ServiceBean_014, on les declare dans le fichier xml.  
On va ajouter un traitement, la méthode **init()** qui sera appelé lors d'initialistion, dans la classe MonBean_014:   

	public class MonBean_014 {

		public MonBean_014() {
			System.out.println("constructeur");
		}
		
		private void init() {
			System.out.println("Je suis la méthode init de la classe MonBean_014");
		}
	}
Il y a **2 façons** d'informer spring d'exécuter cette méthode lors de l'intialisation.
* La première est d'ajouter l'attibut init-method="init" dans le fichier xml là est declaré le bean

    <bean id="monBean" class="fr.bouteraa.zied.maformation_spring_ioc.MonBean_014" init-method="init"></bean>
Lors de chargement Spring détecte qu'il y a une méthode d'intialisation du bean MonBean_014, donc il va l'ajouter dans le phase d'initialisation.  

* la 2eme facon est on va le faire sur le 2em bean ServiceBean_014, il consiste à implementer l'interface InitializingBean dont on va implementer la méthode afterPropertiesSet():  

	public class MonService_014 implements InitializingBean{

		public MonService_014() {
			System.out.println("constructeur");
		}
	
		@Override
		public void afterPropertiesSet() throws Exception {
			System.out.println("Je suis le méthode afterPropertiesSet de la classe MonService_014");
		}
	}

Lors de chargement Spring va détecter toutes les classes qui implementent cette interface **InitializingBean**, et du coup il va greffer le comportement de le méthode afterPropertiesSet à chaque initialisation du Bean de type MonService_014.  
Ci-dessous le resultat d'éxcution:  

	constructeur
	Je suis la méthode init de la classe MonBean_014
	constructeur
	Je suis le méthode afterPropertiesSet de la classe MonService_014
La même chose pour **la destruction** d'un bean spring, ça ce fait avec 2 façons:  

* 1ere façon:on va définir dans le bean MonBean_0014 une méthode destroy() et après on ajoute dans le fichier xml on affecte l'attribut *destroy-method avec "destroy"*, mais il y a une subtilité sur le destruction d'un bean spring,il peut pas etre détruit sans fermer le contexte d'application.
Pour appeller le méthode **close()** sur le contexte d'application, il y a une interface qui s'appelle **ConfigurableApplicationContext** qui implementer par ClassPathXmlApplicationContext, cette interface elle même implemente l'interface closeble et qui expose le méthode close().  

	public class MonBean_014 {

		public MonBean_014() {
			System.out.println("constructeur");
		}
		
		private void init() {
			System.out.println("Je suis la méthode init de la classe MonBean_014");
		}
		
		private void destory() {
			System.out.println("Je suis la méthode destory de la classe MonBean_014");
		}
	}
	
	<bean id="monBean" class="fr.bouteraa.zied.maformation_spring_ioc.MonBean_014" 
	     init-method="init" destroy-method="destory"></bean>
Et le classe main:

	ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:appContext_14.xml");
		applicationContext.close();
* Le 2eme façon pour detruire un bean spring est d'implementer l'interface **DisposableBean**, du coup on va implementer la méthode destroy() 
En exécutons la totalité des deux beans Sppring on aura ça comme résutlat:  

	constructeur
	Je suis la méthode init de la classe MonBean_014
	constructeur
	Je suis le méthode afterPropertiesSet de la classe MonService_014
	Je suis le méthode destroy de la classe MonService_014
	Je suis la méthode destory de la classe MonBean_014

	
### Configuration Java: Declaration d'un bean (MainIoc_016) 

Pour créer un bean en utilisant le configuration Java, il faut 3 choses.  
* Il faut créer une classe de configuration.
* Annoter la classe de configuration avec @Configuration pour informer le contenuer leger d'utiliser cette classe pour créer des beans.
* On crée le bean en declarant une méthode public avec le type de retour qui correspond au type de bean, et annoter cette méthide avec @Bean, pour informer le conteneur que l'objet retourné par la méthode est un bean.    

On peut creér des bean en dehors du fichier de configuration est pour cela on utiliser l'annotation @Component sur une classe.
* @Component sur une classe informe spring qu'il faut utiliser cette classe pour instancier un bean de type de la classe.  (MonService.java)
* Avec l'annotation @ComponentScan permet d'informet spring où va chercher les classes annotées par @Component our par une de ses spécialisations (@Service, @Repository,..)  
26. TODO   