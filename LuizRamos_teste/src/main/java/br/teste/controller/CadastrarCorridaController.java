package br.teste.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.teste.dao.CorridaDAO;

import br.teste.model.CorridaModel;
import br.teste.uteis.Uteis;

@Named(value = "cadastrarCorridaController")
@RequestScoped
public class CadastrarCorridaController {

	@Inject
	CorridaModel corridaModel;

	@Inject
	CorridaDAO corridaRepository;

	public CorridaModel getCorridaModel() {
		return corridaModel;
	}

	public void setTicketModel(CorridaModel corridaModel) {
		this.corridaModel = corridaModel;
	}

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovaCorrida() {

		corridaRepository.SalvarNovoRegistro(this.corridaModel);

		this.corridaModel = null;

		Uteis.MensagemInfo("Registro cadastrado com sucesso");

	}

}