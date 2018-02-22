package br.teste.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_passageiro")

@NamedQueries({
	 
	@NamedQuery(name = "PassageiroEntity.findAll",query= "SELECT e FROM PassageiroEntity e")
 
})

public class PassageiroEntity {
	
	@Id
	@Column(name = "cpf_pas")
	private String cpf_pas;
	
	@Column(name = "nm_passageiro")
	private String nm_passageiro;
 
	@Column(name = "dt_nascimento_pas")
	private Date dt_nascimento_pas;
	
	@Column(name = "sexo")
	private String sexo;

	public String getNm_passageiro() {
		return nm_passageiro;
	}

	public void setNm_passageiro(String nm_passageiro) {
		this.nm_passageiro = nm_passageiro;
	}

	public Date getDt_nascimento_pas() {
		return dt_nascimento_pas;
	}

	public void setDt_nascimento_pas(Date dt_nascimento_pas) {
		this.dt_nascimento_pas = dt_nascimento_pas;
	}

	public String getCpf_pas() {
		return cpf_pas;
	}

	public void setCpf_pas(String cpf_pas) {
		this.cpf_pas = cpf_pas;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
		
}
