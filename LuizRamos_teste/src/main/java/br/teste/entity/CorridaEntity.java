package br.teste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_corrida")

@NamedQueries({

		@NamedQuery(name = "CorridaEntity.findAll", query = "SELECT t FROM CorridaEntity t")		

})

public class CorridaEntity {

	@Id
	@GeneratedValue
	@Column(name = "id_corrida")
	private String id_corrida;

	@Column(name = "motorista")
	private String motorista;

	@Column(name = "passageiro")
	private String passageiro;

	@Column(name = "vl_corrida")
	private Double vl_corrida;

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

	public Double getVl_corrida() {
		return vl_corrida;
	}

	public void setVl_corrida(Double vl_corrida) {
		this.vl_corrida = vl_corrida;
	}
	
}