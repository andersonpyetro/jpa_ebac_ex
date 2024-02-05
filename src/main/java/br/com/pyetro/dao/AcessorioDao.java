package br.com.pyetro.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pyetro.domain.Acessorio;

public class AcessorioDao implements IAcessorioDao {

	@Override
	public Acessorio cadastrar(Acessorio acss) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAebac");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(acss);
		em.getTransaction().commit();

		em.close();
		emf.close();

		return acss;
	}

}
