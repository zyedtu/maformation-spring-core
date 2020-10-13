package fr.bouteraa.zied.dao;

import java.util.Collection;

import fr.bouteraa.zied.modele.Formateur;

public interface FormateurDao {

	void create(Formateur f);

	void update(Formateur f);

	void delete(Formateur f);

	Collection<Formateur> findAll();

	Formateur find(Long id);
}
