package br.com.andreitoledo.boletim.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.andreitoledo.boletim.dao.AlunoDAO;
import br.com.andreitoledo.boletim.model.Aluno;
import br.com.andreitoledo.boletim.util.jpa.Transacional;

public class CadastroAlunoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoDAO alunoDAO;

	@Transacional
	public void salvar(Aluno aluno) throws NegocioException {

		/* regras de validação se tiver... */

		this.alunoDAO.salvar(aluno);

	}

}
