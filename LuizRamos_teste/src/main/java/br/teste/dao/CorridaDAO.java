package br.teste.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.teste.entity.CorridaEntity;
import br.teste.model.CorridaModel;
import br.teste.uteis.Uteis;

public class CorridaDAO {
	
	@Inject
	CorridaEntity corridaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA CORRIDA
	 * @param CorridaModel
	 */
	public void SalvarNovoRegistro(CorridaModel corridaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		corridaEntity = new CorridaEntity();
	
		corridaEntity.setMotorista(corridaModel.getMotorista());
		corridaEntity.setPassageiro(corridaModel.getPassageiro());
		corridaEntity.setVl_corrida(corridaModel.getValor_corrida());
		
		entityManager.persist(corridaEntity);
		
		Uteis.MensagemInfo("Registrado corrida de número '" + corridaEntity.getId_corrida() + "' com sucesso!");
		
	}
	
	/***
	 * MÉTODO PARA CONSULTAR TODOS AS CORRIDAS
	 * @return
	 */
	public List<CorridaModel> GetCorridas(){
 
		List<CorridaModel> corridasModel = new ArrayList<CorridaModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("CorridaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<CorridaEntity> corridasEntity = (Collection<CorridaEntity>)query.getResultList();
 
		CorridaModel corridaModel = null;
 
		for (CorridaEntity corridaEntity : corridasEntity) {
 
			corridaModel = new CorridaModel();
			
			corridaModel.setId_corrida(corridaEntity.getId_corrida());
			corridaModel.setMotorista(corridaEntity.getMotorista());
			corridaModel.setPassageiro(corridaEntity.getPassageiro());
			corridaModel.setValor_corrida(corridaEntity.getVl_corrida());
			
			corridasModel.add(corridaModel);
		
		}
 
		return corridasModel;
 
	}

}