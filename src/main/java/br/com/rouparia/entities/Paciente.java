package br.com.rouparia.entities;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(name="paciente_id", sequenceName="paciente_seq", allocationSize=1)
public class Paciente extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paciente_id")
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	
	@Transient
	private int prioridade;
	
	@Embedded
	private Endereco endereco;
	
	@OneToMany(mappedBy="paciente")
	private List<Dependente> dependentes;
	
	@OneToMany(mappedBy="paciente", fetch=FetchType.EAGER)
	private List<Pedido> pedidos;
	
	
	
	public Paciente(Long id) {
		this.id = id;
	}
	
	public Paciente(){
		
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

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependetes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	
	
}
