package br.com.andreitoledo.boletim.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.andreitoledo.boletim.dao.DisciplinaDAO;
import br.com.andreitoledo.boletim.model.Disciplina;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaDisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	DisciplinaDAO disciplinaDAO;

	private Disciplina disciplinaSelecionado;

	private List<Disciplina> disciplinas = new ArrayList<>();

	@Inject
	private FacesMessages facesMessages;

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@PostConstruct
	public void inicializar() {
		disciplinas = disciplinaDAO.buscarTodos();
	}

	public void excluir() {
		try {
			disciplinaDAO.excluir(disciplinaSelecionado);
			this.disciplinas.remove(disciplinaSelecionado);
			facesMessages.info("Disciplina " + disciplinaSelecionado.getNome()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Disciplina getDisciplinaSelecionado() {
		return disciplinaSelecionado;
	}

	public void setDisciplinaSelecionado(Disciplina disciplinaSelecionado) {
		this.disciplinaSelecionado = disciplinaSelecionado;
	}

}
