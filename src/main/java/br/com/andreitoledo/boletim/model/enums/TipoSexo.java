package br.com.andreitoledo.boletim.model.enums;

public enum TipoSexo {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String descricao;

	private TipoSexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
