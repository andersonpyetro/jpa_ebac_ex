package br.com.pyetro.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pyetro.domain.Carro;

public class CarroDao implements ICarroDao {

	@Override
	public Carro cadastrar(Carro car) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAebac");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();

		em.close();
		emf.close();

		return car;
	}

}
