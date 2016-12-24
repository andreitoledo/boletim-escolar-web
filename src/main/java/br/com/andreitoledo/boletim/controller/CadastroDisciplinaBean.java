package br.com.andreitoledo.boletim.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.andreitoledo.boletim.model.Disciplina;
import br.com.andreitoledo.boletim.service.CadastroDisciplinaService;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroDisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Disciplina disciplina;

	@Inject
	private CadastroDisciplinaService cadastroDisciplinaService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.disciplina == null) {
			limpar();
		}
	}

	private void limpar() {
		this.disciplina = new Disciplina();
	}

	public void salvar() {
		try {
			this.cadastroDisciplinaService.salvar(disciplina);
			facesMessages.info("Disciplina salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public boolean isEditando() {
		return this.disciplina.getCodigo() != null;
	}

}
