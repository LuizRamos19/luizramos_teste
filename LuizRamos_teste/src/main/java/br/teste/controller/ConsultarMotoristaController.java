package br.teste.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.teste.dao.MotoristaDAO;
import br.teste.model.MotoristaModel;
import br.teste.uteis.Uteis;
 
@Named(value="consultarMotoristaController")
@ViewScoped
public class ConsultarMotoristaController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private MotoristaModel motoristaModel;
 
	@Produces 
	private List<MotoristaModel> motoristas;
	
	private List<MotoristaModel> motoristasFiltered;
	
	private List<MotoristaModel> motoristasAtivos;
 
	@Inject transient
	private MotoristaDAO motoristaRepository;
 
	public List<MotoristaModel> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<MotoristaModel> motoristas) {
		this.motoristas = motoristas;
	}	
	
	public List<MotoristaModel> getMotoristasFiltered() {
		return motoristasFiltered;
	}
	
	public void setMotoristasFiltered(List<MotoristaModel> motoristasFiltered) {
		this.motoristasFiltered = motoristasFiltered;
	}
	
	public MotoristaModel getMotoristaModel() {
		return motoristaModel;
	}
	
	public void setMotoristaModel(MotoristaModel motoristaModel) {
		this.motoristaModel = motoristaModel;
	}
	
	public List<MotoristaModel> getMotoristasAtivos() {
		return motoristasAtivos;
	}
	
	public void setMotoristasAtivos(List<MotoristaModel> motoristasAtivos) {
		this.motoristasAtivos = motoristasAtivos;
	}
	
	/***
	 * CARREGA OS MOTORISTAS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		this.motoristas = motoristaRepository.GetMotoristas();
		this.motoristasFiltered = motoristaRepository.GetMotoristas();
		motoristasFiltered.add(motoristaModel);
		this.motoristasAtivos = motoristaRepository.GetMotoristasAtivos();
	}
	
	/***
	 * CARREGA INFORMAÇÕES DE UM MOTORISTA PARA SER EDITADO
	 * @param contatoModel
	 */
	public void Editar(MotoristaModel motoristaModel){
  
		this.motoristaModel = motoristaModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.motoristaRepository.AlterarRegistro(this.motoristaModel);	
		
		Uteis.MensagemInfo("Registro alterado com sucesso");
		
		this.init();
	}

}