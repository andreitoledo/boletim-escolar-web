package br.com.andreitoledo.boletim.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.andreitoledo.boletim.dao.LancamentoDAO;
import br.com.andreitoledo.boletim.model.Lancamento;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	LancamentoDAO lancamentoDAO;

	private Lancamento lancamentoSelecionado;	

	private List<Lancamento> lancamentos = new ArrayList<>();	 

	@Inject
	private FacesMessages facesMessages;

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}	

	@PostConstruct
	public void inicializar() {
		lancamentos = lancamentoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			lancamentoDAO.excluir(lancamentoSelecionado);
			this.lancamentos.remove(lancamentoSelecionado);
			facesMessages.info("Lancamento "
					+ lancamentoSelecionado.getCodigo() + " de "
					+ lancamentoSelecionado.getAluno().getNome()
					+ " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

}
