package br.com.andreitoledo.boletim.model.enums;

public enum TipoLogradouro {
	
	RUA("Rua"),        
	AVENIDA("Avenida"),    
	TRAVESSA("Travessa"),   
	PARALELA("Paralela"),   
	SUBIDA("Subida"),     
	BECO("Beco"),       
	LADEIRA("Ladeira"),    
	LARGO("Largo"),      
	LOTE("Lote"),       
	MORRO("Morro"),      
	PARQUE("Parque"),     
	PASSAGEM("Passagem"),   
	PRACA("Praça"),      
	QUADRA("Quadra"),     
	RECANTO("Recanto"),    
	RESIDENCIAL("Residencial"),
	RODOVIA("Rodovia"),    
	SITIO("Sítio"),      
	TUNEL("Túnel"),      
	VALE("Vale");
	
	private String descricao;

	TipoLogradouro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
