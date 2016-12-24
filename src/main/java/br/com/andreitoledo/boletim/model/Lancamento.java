package br.com.andreitoledo.boletim.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.andreitoledo.boletim.model.enums.TipoAnoEscolar;
import br.com.andreitoledo.boletim.model.enums.TipoClasse;

@Entity
@NamedQueries({ @NamedQuery(name = "Lancamento.buscarTodos", query = "select l from Lancamento l "
		+ " left join fetch l.aluno ") })
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_aluno")
	private Aluno aluno;

	@NotEmpty
	private String ra;

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_ano_escolar")
	private TipoAnoEscolar tipoAnoEscolar; // 3º

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_classe")
	private TipoClasse tipoClasse; // A,B,C

	private Integer numero;

	@NotNull
	@Column(name = "ano_letivo")
	private Integer anoLetivo; // 2016, 2017
	
	@OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LancamentoItem> itens = new ArrayList<>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoAnoEscolar getTipoAnoEscolar() {
		return tipoAnoEscolar;
	}

	public void setTipoAnoEscolar(TipoAnoEscolar tipoAnoEscolar) {
		this.tipoAnoEscolar = tipoAnoEscolar;
	}

	public TipoClasse getTipoClasse() {
		return tipoClasse;
	}

	public void setTipoClasse(TipoClasse tipoClasse) {
		this.tipoClasse = tipoClasse;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(Integer anoLetivo) {
		this.anoLetivo = anoLetivo;
	}	

	public List<LancamentoItem> getItens() {
		return itens;
	}

	public void setItens(List<LancamentoItem> itens) {
		this.itens = itens;
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
		Lancamento other = (Lancamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
