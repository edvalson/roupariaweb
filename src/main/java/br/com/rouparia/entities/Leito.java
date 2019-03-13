package br.com.rouparia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SequenceGenerator(sequenceName="leito_seq", name="leito_id", allocationSize=1)
public class Leito extends AbstractEntity {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY, generator="leito_id")
  private Long id;
  
  @NotEmpty(message="O nome não pode ser vazio")
  private String nome;
  
  @NotEmpty(message="O nome não pode ser vazio")
  private String localizacao;
  
  
  public Leito(Long id) {
		this.id = id;
	}
	
	public Leito(){
		
	}

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

public String getLocalizacao() {
	return localizacao;
}

public void setLocalizacao(String localizacao) {
	this.localizacao = localizacao;
}
  
  
  
  
  
}
