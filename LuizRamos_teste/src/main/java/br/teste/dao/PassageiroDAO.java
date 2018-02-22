package br.teste.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.teste.entity.PassageiroEntity;
import br.teste.model.PassageiroModel;
import br.teste.uteis.Uteis;

public class PassageiroDAO {

	@Inject
	PassageiroEntity passageiroEntity;

	EntityManager entityManager;

	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO PASSAGEIRO
	 * 
	 * @param passageiroModel
	 */
	public void SalvarNovoRegistro(PassageiroModel passageiroModel) {

		entityManager = Uteis.JpaEntityManager();

		passageiroEntity = new PassageiroEntity();
		passageiroEntity.setCpf_pas(passageiroModel.getCpf_pas());
		passageiroEntity.setNm_passageiro(passageiroModel.getNm_passageiro());
		passageiroEntity.setDt_nascimento_pas(passageiroModel.getDt_nascimento_pas());
		passageiroEntity.setSexo(passageiroModel.getSexo());
		
		entityManager.persist(passageiroEntity);

	}

	/***
	 * MÉTODO PARA CONSULTAR O PASSAGEIRO
	 * 
	 * @return
	 */
	public List<PassageiroModel> GetPassageiros() {

		List<PassageiroModel> passageirosModel = new ArrayList<PassageiroModel>();

		entityManager = Uteis.JpaEntityManager();

		Query query = entityManager.createNamedQuery("PassageiroEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<PassageiroEntity> passageirosEntity = (Collection<PassageiroEntity>) query.getResultList();

		PassageiroModel passageiroModel = null;

		for (PassageiroEntity passageiroEntity : passageirosEntity) {

			passageiroModel = new PassageiroModel();
			passageiroModel.setCpf_pas(passageiroEntity.getCpf_pas());
			passageiroModel.setNm_passageiro(passageiroEntity.getNm_passageiro());
			passageiroModel.setDt_nascimento_pas(passageiroEntity.getDt_nascimento_pas());
			passageiroModel.setSexo(passageiroEntity.getSexo());

			passageirosModel.add(passageiroModel);
		}

		return passageirosModel;

	}

	/***
	 * VALIDA SE O CPF DO PASSAGEIRO JÁ EXISTE NO BANCO DE DADOS
	 * 
	 * @param cpf
	 */
	public PassageiroEntity ValidaCpf(String cpf) {
		entityManager = Uteis.JpaEntityManager();

		return entityManager.find(PassageiroEntity.class, cpf);

	}
	
	//CODIGO PAR AKJDGJDFJGFJGHJFHGJJGHJHFHGDFJHGJFHGJJDHGJDFHGJFHGJDFHGJDFGHJDHGJDFHGFJDHGFDH

	/***
	 * VALIDA SE O NOME DA EMPRESA JÁ EXISTE NO BANCO DE DADOS
	 * 
	 * @param nome
	 */
	public PassageiroEntity ValidaNome(String nome) {
		
		try {

			Query query = Uteis.JpaEntityManager().createNamedQuery("EmpresaEntity.findName");

			query.setParameter("nome", nome);
				
			return (PassageiroEntity) query.getSingleResult();
		}catch(Exception e) {
			return null;
		}

	}

}
