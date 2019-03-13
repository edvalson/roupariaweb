package br.com.rouparia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="dependente_id", sequenceName="dependente_seq", allocationSize=1)
public class Dependente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dependente_id")
	private Long id;
	
	private String nome;
	
	@ManyToOne
	private Paciente paciente;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
