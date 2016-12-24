package br.com.andreitoledo.boletim.model;

import javax.persistence.Column;

public class Boletim {
	
	private Long codigo;
	
	@Column(name = "total_ponto")
	private double totalPonto; // TP
	
	/* resultado por bimestre */
	@Column(name = "media_parcial")
	private double mediaParcial; // MP
	@Column(name = "aula_dada")
	private Integer aulaDada; // AD
	@Column(name = "total_falta")
	private Integer totalFalta; // TF
	@Column(name = "total_ausencia_compensacao")
	private Integer totalAusenciaCompensacao; // TAC

	/* resultado final */
	@Column(name = "media_final")
	private double mediaFinal; // MF
	@Column(name = "resultado_final")
	private String resultadoFinal; // aprovado ou reprovado




}
