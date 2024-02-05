package br.com.pyetro;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.pyetro.dao.AcessorioDao;
import br.com.pyetro.dao.CarroDao;
import br.com.pyetro.dao.IMarcaDao;
import br.com.pyetro.dao.MarcaDao;
import br.com.pyetro.domain.Acessorio;
import br.com.pyetro.domain.Carro;
import br.com.pyetro.domain.Marca;

public class MarcaTest {

	private IMarcaDao marcaDao;
	private CarroDao carroDao;
	private AcessorioDao acessorioDao;

	public MarcaTest() {
		marcaDao = new MarcaDao();
		carroDao = new CarroDao();
		acessorioDao = new AcessorioDao();
	}

	@Test
	public void cadastrar() {
		Marca marca = criarMarca("M1");
		Carro carro = criarCarro("C1", marca);
		Acessorio acessorio = criarAcessorio("A1", carro);

		assertNotNull(marca);
		assertNotNull(marca.getId());

	
	}

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("Marca Teste");
	
		return marcaDao.cadastrar(marca);
	}

	private Carro criarCarro(String codigo, Marca marca) {
		Carro carro = new Carro();
		carro.setCodigo(codigo);
		carro.setNome("Carro Teste");
		carro.setValor(50000.0); 
		carro.setMarca(marca);
		return carroDao.cadastrar(carro);
	}

	private Acessorio criarAcessorio(String codigo, Carro carro) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo(codigo);
		acessorio.setCarro(carro);
		return acessorioDao.cadastrar(acessorio);
	}
}
