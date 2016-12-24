package br.com.andreitoledo.boletim.model.enums;

public enum TipoBimestre {
	
	PRIMEIROBIMESTRE("1º Bimestre"),
	SEGUNDOBIMESTRE("2º Bimestre"),
	TERCEIROBIMESTRE("3º Bimestre"),
	QUARTOBIMESTRE("4º Bimestre");
	
	private String descricao;

	private TipoBimestre(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
