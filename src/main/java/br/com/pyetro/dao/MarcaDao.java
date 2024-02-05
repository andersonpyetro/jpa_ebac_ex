package br.com.pyetro.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pyetro.domain.Marca;

public class MarcaDao implements IMarcaDao{

	@Override
	public Marca cadastrar(Marca mar) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAebac");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(mar);
		em.getTransaction().commit();

		em.close();
		emf.close();

		return mar;
	}

}
