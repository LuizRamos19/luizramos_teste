package br.teste.model;

public class CorridaModel {
	
	private String id_corrida;
	private String motorista;
	private String passageiro;
	private Double valor_corrida;
	
	public String getId_corrida() {
		return id_corrida;
	}

	public void setId_corrida(String id_corrida) {
		this.id_corrida = id_corrida;
	}
	
	public String getMotorista() {
		return motorista;
	}
	
	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}
	
	public String getPassageiro() {
		return passageiro;
	}
	
	public void setPassageiro(String passageiro) {
		this.passageiro = passageiro;
	}
	
	public Double getValor_corrida() {
		return valor_corrida;
	}
	
	public void setValor_corrida(Double valor_corrida) {
		this.valor_corrida = valor_corrida;
	}
		
}