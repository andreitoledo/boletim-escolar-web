package br.com.andreitoledo.boletim.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.andreitoledo.boletim.dao.AlunoDAO;
import br.com.andreitoledo.boletim.model.Aluno;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AlunoDAO alunoDAO;	

	private Aluno alunoSelecionado;
	
	private List<Aluno> alunos = new ArrayList<>();

	@Inject
	private FacesMessages facesMessages;

	public List<Aluno> getAlunos() {
		return alunos;
	}

	@PostConstruct
	public void inicializar() {
		alunos = alunoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			alunoDAO.excluir(alunoSelecionado);
			this.alunos.remove(alunoSelecionado);
			facesMessages.info("Aluno " 
					+ alunoSelecionado.getNome()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

}
