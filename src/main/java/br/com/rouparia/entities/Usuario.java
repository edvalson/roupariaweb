package br.com.rouparia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SequenceGenerator(name="usuario_id", sequenceName="usuario_seq", allocationSize=1)
public class Usuario extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_id")
	private Long id;
	
	@NotEmpty(message="{erro.login}")
	private String login;
	
	@NotEmpty(message="{erro.senha}")
	private String senha;

	public Usuario(Long id) {
		this.id = id;
	}
	
	public Usuario(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	
}
