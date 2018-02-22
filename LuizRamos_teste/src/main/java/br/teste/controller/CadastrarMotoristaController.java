package br.teste.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.teste.dao.MotoristaDAO;
import br.teste.entity.MotoristaEntity;
import br.teste.model.MotoristaModel;
import br.teste.uteis.Uteis;

@Named(value = "cadastrarMotoristaController")
@RequestScoped
public class CadastrarMotoristaController {

	@Inject
	MotoristaModel motoristaModel;

	@Inject
	MotoristaDAO motoristaRepository;

	public MotoristaModel getMotoristaModel() {
		return motoristaModel;
	}

	public void setMotoristaModel(MotoristaModel motoristaModel) {
		this.motoristaModel = motoristaModel;
	}

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovoMotorista() {

		MotoristaEntity motoristaEntity = motoristaRepository.ValidaCpf(this.motoristaModel.getCpf_mot());

		if (motoristaEntity == null) {

			motoristaRepository.SalvarNovoRegistro(this.motoristaModel);

			this.motoristaModel = null;

			Uteis.MensagemInfo("Registro cadastrado com sucesso");

		} else {
			Uteis.MensagemAtencao("Já existe um motorista com este CPF no sistema!");
		}

	}

}