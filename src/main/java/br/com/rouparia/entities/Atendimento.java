package br.com.rouparia.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(name="atendimento_id", sequenceName="atendimento_seq", allocationSize=1)
public class Atendimento extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="atendimento_id")
	private Long id;
	
	@Transient
	private List<Long> pacientes;
	
	public List<Long> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Long> pacientes) {
		this.pacientes = pacientes;
	}

	private String tipoAtendimento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date DataAtendimento;
	
	
	@ManyToOne
	private Paciente paciente;
	
	
	@OneToOne
	private Leito leito;
	
	public Leito getLeito() {
		return leito;
	}

	public void setLeito(Leito leito) {
		this.leito = leito;
	}

	public Atendimento(Long id) {
		this.id = id;
	}
	
	public Atendimento(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getDataAtendimento() {
		return DataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		DataAtendimento = dataAtendimento;
	}

	

	
	
	
	

	
}	