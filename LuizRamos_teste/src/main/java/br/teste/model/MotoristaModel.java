package br.teste.model;

import java.util.Date;

public class MotoristaModel {
	
	private String nm_motorista;
	private Date dt_nascimento_mot;
	private String cpf_mot;
	private String carro_model;
	private String status;
	private String sexo;
	
	public String getNm_motorista() {
		return nm_motorista;
	}
	
	public void setNm_motorista(String nm_motorista) {
		this.nm_motorista = nm_motorista;
	}
	
	public Date getDt_nascimento_mot() {
		return dt_nascimento_mot;
	}
	
	public void setDt_nascimento_mot(Date dt_nascimento_mot) {
		this.dt_nascimento_mot = dt_nascimento_mot;
	}
	
	public String getCpf_mot() {
		return cpf_mot;
	}
	
	public void setCpf_mot(String cpf_mot) {
		this.cpf_mot = cpf_mot;
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