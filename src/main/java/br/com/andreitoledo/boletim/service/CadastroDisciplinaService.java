package br.com.andreitoledo.boletim.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.andreitoledo.boletim.dao.DisciplinaDAO;
import br.com.andreitoledo.boletim.model.Disciplina;
import br.com.andreitoledo.boletim.util.jpa.Transacional;

public class CadastroDisciplinaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DisciplinaDAO disciplinaDAO;

	@Transacional
	public void salvar(Disciplina disciplina) throws NegocioException {

		/* regras de validação se tiver... */

		this.disciplinaDAO.salvar(disciplina);

	}

}
