package br.com.andreitoledo.boletim.model.enums;

public enum TipoAnoEscolar {
	
	PRIMEIROANOFUNDAMENTAL("1º Ano Fundamental"),
	SEGUNDOANOFUNDAMENTAL("2º Ano Fundamental"),
	TERCEIROANOFUNDAMENTAL("3º Ano Fundamental"),
	QUARTOANOFUNDAMENTAL("4º Ano Fundamental"),
	QUINTOANOFUNDAMENTAL("5º Ano Fundamental"),
	SEXTOANOFUNDAMENTAL("6º Ano Fundamental"),
	SETIMOANOFUNDAMENTAL("7º Ano Fundamental"),
	OITAVOANOFUNDAMENTAL("8º Ano Fundamental"),
	NONOANOFUNDAMENTAL("9º Ano Fundamental"),
	PRIMEIROANOMEDIO("1º Ano Médio"),
	SEGUNDOOANOMEDIO("2º Ano Médio"),
	TERCEIROANOMEDIO("3º Ano Médio"),
	PRIMEIROANOSUPERIOR("1º Ano Superior"),
	SEGUNDOANOSUPERIOR("2º Ano Superior"),
	TERCEIROANOSUPERIOR("3º Ano Superior"),
	QUARTOANOSUPERIOR("4º Ano Superior"),
	QUINTOANOSUPERIOR("5º Ano Superior");
	
	private String descricao;

	private TipoAnoEscolar(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}