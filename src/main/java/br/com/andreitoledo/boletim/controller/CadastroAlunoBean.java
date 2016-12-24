package br.com.andreitoledo.boletim.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.andreitoledo.boletim.model.Aluno;
import br.com.andreitoledo.boletim.model.enums.TipoLogradouro;
import br.com.andreitoledo.boletim.model.enums.TipoSexo;
import br.com.andreitoledo.boletim.service.CadastroAlunoService;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroAlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;

	@Inject
	private CadastroAlunoService CadastroAlunoService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.aluno == null) {
			limpar();

		}
	}

	private void limpar() {
		this.aluno = new Aluno();
	}

	public void salvar() {
		try {
			this.CadastroAlunoService.salvar(aluno);
			facesMessages.info("Aluno salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}	

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public TipoSexo[] getTipoSexos(){
		return TipoSexo.values();
	}
	
	public TipoLogradouro[] getTipoLogradouros(){
		return TipoLogradouro.values();
	}

	public boolean isEditando() {
		return this.aluno.getCodigo() != null;
	}

}
