package br.com.andreitoledo.boletim.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.andreitoledo.boletim.model.Aluno;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jpa.Transacional;

public class AlunoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Aluno buscarPeloCodigo(Long codigo) {
		return manager.find(Aluno.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> buscarTodos() {
		return manager.createNamedQuery("Aluno.buscarTodos").getResultList();
	}

	public void salvar(Aluno aluno) {
		manager.merge(aluno);
	}
	
	@Transacional
	public void excluir(Aluno aluno) throws NegocioException {
		aluno = buscarPeloCodigo(aluno.getCodigo());
		try {
			manager.remove(aluno);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Este Aluno não pode ser exluído.");
		}
	}

}
