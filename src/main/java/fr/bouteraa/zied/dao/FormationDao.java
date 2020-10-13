package fr.bouteraa.zied.dao;

import java.util.List;

import fr.bouteraa.zied.modele.Formation;

public interface FormationDao {

	String quiSuisJe();

	List<Formation> findAll();
}
