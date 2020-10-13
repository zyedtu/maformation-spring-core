package fr.bouteraa.zied.service;

import java.util.Collection;

import fr.bouteraa.zied.dao.FormateurDao;
import fr.bouteraa.zied.modele.Formateur;

public class FormateurServiceImpl implements FormateurService {

	private FormateurDao formateurDao;

	public FormateurServiceImpl(final FormateurDao formateurDao) {
		super();
		this.formateurDao = formateurDao;
	}

	@Override
	public void create(final Formateur f) {
		formateurDao.create(f);

	}

	@Override
	public void update(final Formateur f) {
		formateurDao.update(f);
	}

	@Override
	public void delete(final Formateur f) {
		formateurDao.delete(f);

	}

	@Override
	public Collection<Formateur> findAll() {
		return formateurDao.findAll();
	}

	@Override
	public Formateur find(final Long id) {
		return formateurDao.find(id);
	}

	public void setFormateurDao(final FormateurDao formateurDao) {
		this.formateurDao = formateurDao;
	}

	@Override
	public void create(final Collection<Formateur> formateurs) {
		// TODO Auto-generated method stub

	}

}
