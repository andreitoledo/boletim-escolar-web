package br.com.andreitoledo.boletim.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.andreitoledo.boletim.dao.AlunoDAO;
import br.com.andreitoledo.boletim.model.Aluno;

@FacesConverter(forClass=Aluno.class)
public class AlunoConverter implements Converter{
	
	@Inject
	private AlunoDAO alunoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Aluno retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			retorno = this.alunoDAO.buscarPeloCodigo(new Long(value));
			
		}		

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		if (value !=null) {
			Long codigo = ((Aluno) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
			
		}

		return "";
	}

}
