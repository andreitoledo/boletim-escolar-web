package br.com.andreitoledo.boletim.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.andreitoledo.boletim.model.Disciplina;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jpa.Transacional;

public class DisciplinaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Disciplina buscarPeloCodigo(Long codigo){
		return manager.find(Disciplina.class, codigo);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> buscarTodos(){
		return manager.createNamedQuery("Disciplina.buscarTodos").getResultList();		
	}
	
	public void salvar(Disciplina disciplina){
		manager.merge(disciplina);		
	}
	
	@Transacional
	public void excluir(Disciplina disciplina) throws NegocioException{		
		disciplina = buscarPeloCodigo(disciplina.getCodigo());
		
		try {
			manager.remove(disciplina);
			manager.flush();
			
		} catch (PersistenceException e) {
			throw new NegocioException("Esta disciplina não pode ser excluído.");

		}
		
	}
	

}
