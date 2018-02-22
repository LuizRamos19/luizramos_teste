package br.teste.model;

import java.util.Date;

public class PassageiroModel {
	
	private String nm_passageiro;
	private Date dt_nascimento_pas;
	private String cpf_pas;
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