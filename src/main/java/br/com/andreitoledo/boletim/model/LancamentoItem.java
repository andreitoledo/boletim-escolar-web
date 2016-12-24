package br.com.andreitoledo.boletim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.andreitoledo.boletim.model.enums.TipoBimestre;

@Entity
@Table(name = "lancamento_item")
public class LancamentoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	private TipoBimestre tipoBimestre;
	
	@ManyToOne
	@JoinColumn(name = "codigo_disciplina")
	private Disciplina disciplina;

	private double nota;
	private Integer falta;
	@Column(name = "compensacao_ausencia")
	private Integer compensacaoAusencia;
	
	@ManyToOne
	private Lancamento lancamento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoBimestre getTipoBimestre() {
		return tipoBimestre;
	}

	public void setTipoBimestre(TipoBimestre tipoBimestre) {
		this.tipoBimestre = tipoBimestre;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Integer getFalta() {
		return falta;
	}

	public void setFalta(Integer falta) {
		this.falta = falta;
	}

	public Integer getCompensacaoAusencia() {
		return compensacaoAusencia;
	}

	public void setCompensacaoAusencia(Integer compensacaoAusencia) {
		this.compensacaoAusencia = compensacaoAusencia;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LancamentoItem other = (LancamentoItem) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
