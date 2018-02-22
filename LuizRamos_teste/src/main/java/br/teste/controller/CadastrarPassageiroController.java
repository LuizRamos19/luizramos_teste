package br.teste.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.teste.dao.PassageiroDAO;
import br.teste.entity.PassageiroEntity;
import br.teste.model.PassageiroModel;
import br.teste.uteis.Uteis;

@Named(value = "cadastrarPassageiroController")
@RequestScoped
public class CadastrarPassageiroController {

	@Inject
	PassageiroModel passageiroModel;

	@Inject
	PassageiroDAO passageiroRepository;

	public PassageiroModel getPassageiroModel() {
		return passageiroModel;
	}

	public void setPassageiroModel(PassageiroModel passageiroModel) {
		this.passageiroModel = passageiroModel;
	}

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovoPassageiro() {

		PassageiroEntity passageiroEntity = passageiroRepository.ValidaCpf(this.passageiroModel.getCpf_pas());

		if (passageiroEntity == null) {

			passageiroRepository.SalvarNovoRegistro(this.passageiroModel);

			this.passageiroModel = null;

			Uteis.MensagemInfo("Registro cadastrado com sucesso");

		} else {
			Uteis.MensagemAtencao("Já existe um passageiro com este CPF no sistema!");
		}
		
	}

}