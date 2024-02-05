package br.com.pyetro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acss_seq")
	@SequenceGenerator(name = "acss_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 10)
	private Long id;

	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;

	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "VALOR", nullable = false)
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "carro_id")
	private Carro carro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	

}
