package br.com.andreitoledo.boletim.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.andreitoledo.boletim.dao.LancamentoDAO;
import br.com.andreitoledo.boletim.model.Lancamento;
import br.com.andreitoledo.boletim.util.jpa.Transacional;

public class CadastroLancamentoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LancamentoDAO lancamentoDAO;
	
	@Transacional
	public void salvar(Lancamento lancamento) throws NegocioException{
		
		this.lancamentoDAO.salvar(lancamento);
		
	}

}
