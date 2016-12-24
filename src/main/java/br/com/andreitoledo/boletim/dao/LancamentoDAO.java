package br.com.andreitoledo.boletim.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.andreitoledo.boletim.model.Lancamento;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jpa.Transacional;

public class LancamentoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Lancamento buscarPeloCodigo(Long codigo) {
		return manager.find(Lancamento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Lancamento> buscarTodos() {
		return manager.createNamedQuery("Lancamento.buscarTodos")
				.getResultList();
	}

	public void salvar(Lancamento lancamento) {
		manager.merge(lancamento);
	}

	@Transacional
	public void excluir(Lancamento lancamento) throws NegocioException {
		lancamento = buscarPeloCodigo(lancamento.getCodigo());
		try {
			manager.remove(lancamento);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Este Lançamento não pode ser exluído.");

		}

	}

}
