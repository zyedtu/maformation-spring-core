package fr.bouteraa.zied.service;

import java.util.Collection;

import fr.bouteraa.zied.modele.Formateur;

public interface FormateurService {

	void create(Formateur f);

	void create(Collection<Formateur> formateurs);

	void update(Formateur f);

	void delete(Formateur f);

	Collection<Formateur> findAll();

	Formateur find(Long id);
}
