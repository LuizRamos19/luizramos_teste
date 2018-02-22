package br.teste.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.teste.dao.PassageiroDAO;
import br.teste.model.PassageiroModel;
 
@Named(value="consultarPassageiroController")
@ViewScoped
public class ConsultarPassageiroController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private PassageiroModel passageiroModel;
 
	@Produces 
	private List<PassageiroModel> passageiros;
	
	private List<PassageiroModel> passageirosFiltered;

	@Inject transient
	private PassageiroDAO passageiroRepository;
 
	public List<PassageiroModel> getPassageiros() {
		return passageiros;
	}
	
	public void setPassageiros(List<PassageiroModel> passageiros) {
		this.passageiros = passageiros;
	}		
	
	public PassageiroModel getPassageiroModel() {
		return passageiroModel;
	}
	
	public void setPassageiroModel(PassageiroModel passageiroModel) {
		this.passageiroModel = passageiroModel;
	}
	
	public List<PassageiroModel> getPassageirosFiltered() {
		return passageirosFiltered;
	}

	public void setPassageirosFiltered(List<PassageiroModel> passageirosFiltered) {
		this.passageirosFiltered = passageirosFiltered;
	}

	/***
	 * CARREGA OS PASSAGEIROS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		this.passageiros = passageiroRepository.GetPassageiros();
		this.passageirosFiltered = passageiroRepository.GetPassageiros();
		passageirosFiltered.add(passageiroModel);
	}

}