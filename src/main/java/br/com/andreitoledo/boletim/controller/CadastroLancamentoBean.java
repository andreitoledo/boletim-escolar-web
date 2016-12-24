package br.com.andreitoledo.boletim.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.andreitoledo.boletim.dao.AlunoDAO;
import br.com.andreitoledo.boletim.dao.DisciplinaDAO;
import br.com.andreitoledo.boletim.model.Aluno;
import br.com.andreitoledo.boletim.model.Disciplina;
import br.com.andreitoledo.boletim.model.Lancamento;
import br.com.andreitoledo.boletim.model.LancamentoItem;
import br.com.andreitoledo.boletim.model.enums.TipoAnoEscolar;
import br.com.andreitoledo.boletim.model.enums.TipoBimestre;
import br.com.andreitoledo.boletim.model.enums.TipoClasse;
import br.com.andreitoledo.boletim.service.CadastroLancamentoService;
import br.com.andreitoledo.boletim.service.NegocioException;
import br.com.andreitoledo.boletim.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Lancamento lancamento;

	private List<Aluno> alunos;

	private List<Disciplina> disciplinas;

	@Inject
	private AlunoDAO alunoDAO;

	@Inject
	private DisciplinaDAO disciplinaDAO;

	@Inject
	private CadastroLancamentoService cadastroLancamentoService;

	@Inject
	private FacesMessages facesMessages;

	private LancamentoItem item;

	public void inicializar() {
		if (this.lancamento == null) {
			limpar();
		}

		if (this.item == null) {
			this.item = new LancamentoItem();

		}

		this.alunos = this.alunoDAO.buscarTodos();
		this.disciplinas = this.disciplinaDAO.buscarTodos();
	}

	private void limpar() {
		this.lancamento = new Lancamento();
	}

	public void novoItem() {
		item = new LancamentoItem();

	}

	public void adicionarItem() {
		lancamento.getItens().add(item);
		item.setLancamento(lancamento);
	}

	public void salvar() {
		try {
			this.cadastroLancamentoService.salvar(lancamento);
			facesMessages.info("Lancamento salvo com Sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public LancamentoItem getItem() {
		return item;
	}

	public TipoAnoEscolar[] getTipoAnoEscolars() {
		return TipoAnoEscolar.values();
	}

	public TipoClasse[] getTipoClasses() {
		return TipoClasse.values();
	}

	public TipoBimestre[] getTipoBimestres() {
		return TipoBimestre.values();
	}

	public boolean isEditando() {
		return this.lancamento.getCodigo() != null;
	}

}
