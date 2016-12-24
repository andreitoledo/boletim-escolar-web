package br.com.andreitoledo.boletim.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.andreitoledo.boletim.dao.LancamentoDAO;
import br.com.andreitoledo.boletim.model.Lancamento;

@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {

	@Inject
	private LancamentoDAO lancamentoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Lancamento retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.lancamentoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			Long codigo = ((Lancamento) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
