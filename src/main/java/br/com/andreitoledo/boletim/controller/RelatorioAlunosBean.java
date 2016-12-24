package br.com.andreitoledo.boletim.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;

import br.com.andreitoledo.boletim.util.jsf.FacesUtil;
import br.com.andreitoledo.boletim.util.report.ExecutorRelatorio;

@Named
@RequestScoped
public class RelatorioAlunosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private HttpServletResponse response;

	@Inject
	private EntityManager manager;
	
	private Long codigoLancamento;

	public void emitir() {
		Map<String, Object> parametros = new HashMap<>();		

		ExecutorRelatorio executor = new ExecutorRelatorio(
				"/relatorios/relatorio_contatos_alunos.jasper", this.response,
				parametros, "Contatos alunos.pdf");

		Session session = manager.unwrap(Session.class);
		session.doWork(executor);

		if (executor.isRelatorioGerado()) {
			facesContext.responseComplete();
		} else {
			FacesUtil
					.addErrorMessage("A execução do relatório não retornou dados.");
		}
	}

	public void emitirBoletim() {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("LANCAMENTO_CODIGO", this.codigoLancamento);

		ExecutorRelatorio executor = new ExecutorRelatorio(
				"/relatorios/relatorio_boletim_lancamentos.jasper", this.response,
				parametros, "Boletim alunos.pdf");

		Session session = manager.unwrap(Session.class);
		session.doWork(executor);

		if (executor.isRelatorioGerado()) {
			facesContext.responseComplete();
		} else {
			FacesUtil
					.addErrorMessage("A execução do relatório não retornou dados.");
		}

	}

	@NotNull
	public Long getCodigoLancamento() {
		return codigoLancamento;
	}

	public void setCodigoLancamento(Long codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}
	
	

}
