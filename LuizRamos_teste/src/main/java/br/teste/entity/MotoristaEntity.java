package br.teste.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_motorista")

@NamedQueries({
	 
	@NamedQuery(name = "MotoristaEntity.findAll",query= "SELECT c FROM MotoristaEntity c"),
	@NamedQuery(name = "MotoristaEntity.findActive", query= "SELECT a FROM MotoristaEntity a WHERE a.status = 'Ativo'")
 
})

public class MotoristaEntity {
	
	@Id
	@Column(name = "cpf_mot")
	private String cpf_mot;

	@Column(name = "dt_nascimento_mot")
	private Date dt_nascimento_mot;
	
	@Column(name = "nm_motorista")
	private String nm_motorista;
	
	@Column(name = "carro_model")
	private String carro_model;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "sexo")
	private String sexo;

	public String getCpf_mot() {
		return cpf_mot;
	}

	public void setCpf_mot(String cpf_mot) {
		this.cpf_mot = cpf_mot;
	}

	public Date getDt_nascimento_mot() {
		return dt_nascimento_mot;
	}

	public void setDt_nascimento_mot(Date dt_nascimento_mot) {
		this.dt_nascimento_mot = dt_nascimento_mot;
	}

	public String getNm_motorista() {
		return nm_motorista;
	}

	public void setNm_motorista(String nm_motorista) {
		this.nm_motorista = nm_motorista;
	}

	public String getCarro_model() {
		return carro_model;
	}

	public void setCarro_model(String carro_model) {
		this.carro_model = carro_model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
		
}