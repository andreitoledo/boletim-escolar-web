package br.com.andreitoledo.boletim.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.andreitoledo.boletim.dao.DisciplinaDAO;
import br.com.andreitoledo.boletim.model.Disciplina;

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

	@Inject
	private DisciplinaDAO disciplinaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Disciplina retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.disciplinaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			Long codigo = ((Disciplina) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
