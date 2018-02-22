package br.teste.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.teste.entity.MotoristaEntity;
import br.teste.model.MotoristaModel;
import br.teste.uteis.Uteis;

public class MotoristaDAO {
	
	@Inject
	MotoristaEntity motoristaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO motorista
	 * @param motoristaModel
	 */
	public void SalvarNovoRegistro(MotoristaModel motoristaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		motoristaEntity = new MotoristaEntity();
	
		motoristaEntity.setCpf_mot(motoristaModel.getCpf_mot());
		motoristaEntity.setNm_motorista(motoristaModel.getNm_motorista());
		motoristaEntity.setDt_nascimento_mot(motoristaModel.getDt_nascimento_mot());
		motoristaEntity.setCarro_model(motoristaModel.getCarro_model());
		motoristaEntity.setStatus(motoristaModel.getStatus());
		motoristaEntity.setSexo(motoristaModel.getSexo());
		
		entityManager.persist(motoristaEntity);
		
	}
	
	/***
	 * MÉTODO PARA CONSULTAR O MOTORISTA
	 * @return
	 */
	public List<MotoristaModel> GetMotoristas(){
 
		List<MotoristaModel> motoristasModel = new ArrayList<MotoristaModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("MotoristaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<MotoristaEntity> motoristasEntity = (Collection<MotoristaEntity>)query.getResultList();
 
		MotoristaModel motoristaModel = null;
 
		for (MotoristaEntity motoristaEntity : motoristasEntity) {
 
			motoristaModel = new MotoristaModel();
			
			motoristaModel.setCpf_mot(motoristaEntity.getCpf_mot());
			motoristaModel.setNm_motorista(motoristaEntity.getNm_motorista());
			motoristaModel.setDt_nascimento_mot(motoristaEntity.getDt_nascimento_mot());
			motoristaModel.setCarro_model(motoristaEntity.getCarro_model());
			motoristaModel.setStatus(motoristaEntity.getStatus());
			motoristaModel.setSexo(motoristaEntity.getSexo());
			
			motoristasModel.add(motoristaModel);
		}
 
		return motoristasModel;
 
	}
	
	/***
	 * CONSULTA UM MOTORISTA CADASTRADO PELO SEU CPF
	 * @param cpf
	 * @return
	 */
	private MotoristaEntity GetMotorista(String cpf){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(MotoristaEntity.class, cpf);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param motoristaModel
	 */
	public void AlterarRegistro(MotoristaModel motoristaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		MotoristaEntity motoristaEntity = this.GetMotorista(motoristaModel.getCpf_mot());
		
		motoristaEntity.setCpf_mot(motoristaModel.getCpf_mot());
		motoristaEntity.setNm_motorista(motoristaModel.getNm_motorista());
		motoristaEntity.setDt_nascimento_mot(motoristaModel.getDt_nascimento_mot());
		motoristaEntity.setCarro_model(motoristaModel.getCarro_model());
		motoristaEntity.setStatus(motoristaModel.getStatus());
		motoristaEntity.setSexo(motoristaModel.getSexo());
		
		entityManager.merge(motoristaEntity);
	}
	
	/***
	 * MÉTODO PARA CONSULTAR OS MOTORISTAS ATIVOS PARA CADASTRO DAS CORRIDAS
	 * @return
	 */
	public List<MotoristaModel> GetMotoristasAtivos() {
		
		List<MotoristaModel> motoristasModel = new ArrayList<MotoristaModel>();
		 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("MotoristaEntity.findActive");
 
		@SuppressWarnings("unchecked")
		Collection<MotoristaEntity> motoristasEntity = (Collection<MotoristaEntity>)query.getResultList();
 
		MotoristaModel motoristaModel = null;
 
		for (MotoristaEntity motoristaEntity : motoristasEntity) {
 
			motoristaModel = new MotoristaModel();
			
			motoristaModel.setCpf_mot(motoristaEntity.getCpf_mot());
			motoristaModel.setNm_motorista(motoristaEntity.getNm_motorista());
			motoristaModel.setDt_nascimento_mot(motoristaEntity.getDt_nascimento_mot());
			motoristaModel.setCarro_model(motoristaEntity.getCarro_model());
			motoristaModel.setStatus(motoristaEntity.getStatus());
			motoristaModel.setSexo(motoristaEntity.getSexo());
			
			motoristasModel.add(motoristaModel);
		}
 
		return motoristasModel;
		
	}
	
	/***
	 * VALIDA SE O CPF EXISTE NO BANCO DE DADOS
	 * @param cpf
	 */
	public MotoristaEntity ValidaCpf(String cpf) {
		entityManager = Uteis.JpaEntityManager();
		
		return entityManager.find(MotoristaEntity.class, cpf);
		
	}

}