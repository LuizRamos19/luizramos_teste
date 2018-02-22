package br.teste.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.teste.dao.CorridaDAO;
import br.teste.model.CorridaModel;
 
@Named(value="consultarCorridaController")
@ViewScoped
public class ConsultarCorridaController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private CorridaModel corridaModel;
 
	@Produces 
	private List<CorridaModel> corridas;
	
	private List<CorridaModel> corridasFiltered;

	@Inject transient
	private CorridaDAO corridaRepository;
 
	public List<CorridaModel> getCorridas() {
		return corridas;
	}
	
	public void setCorridas(List<CorridaModel> corridas) {
		this.corridas = corridas;
	}		
	
	public CorridaModel getCorridaModel() {
		return corridaModel;
	}
	
	public void setCorridaModel(CorridaModel corridaModel) {
		this.corridaModel = corridaModel;
	}
 
	public List<CorridaModel> getCorridasFiltered() {
		return corridasFiltered;
	}
	
	public void setCorridasFiltered(List<CorridaModel> corridasFiltered) {
		this.corridasFiltered = corridasFiltered;
	}
	
	/***
	 * CARREGA AS CORRIDAS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		this.corridas = corridaRepository.GetCorridas();
		this.corridasFiltered = corridaRepository.GetCorridas();
		corridasFiltered.add(corridaModel);
	}

}