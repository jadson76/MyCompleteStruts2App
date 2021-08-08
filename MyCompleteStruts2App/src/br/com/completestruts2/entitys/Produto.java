package br.com.completestruts2.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto", schema = "struts_app")
@NamedQueries({
	@NamedQuery( name = "Produto.findAll",
		    query = "SELECT p FROM Produto p"),
	@NamedQuery( name = "Produto.findById",
    query = "SELECT p FROM Produto p WHERE p.id = :id"),
	@NamedQuery( name = "Produto.findByNome",
    query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
	@NamedQuery( name = "Produto.findByPreco",
    query = "SELECT p FROM Produto p WHERE p.preco = :preco")
	
})
public class Produto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id",nullable = false)
	private Long id;
	
	@Basic(optional = false)
	@Column(name = "nome",nullable = false, length = 100)
	private String nome;
	
	@Basic(optional = false)	
	@Column(name = "preco",nullable = false, precision = 16, scale = 2)
	private BigDecimal preco;	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
	private List<FiscalItem> fiscalItemList;

	public Produto(Long id, String nome, BigDecimal preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}	
	

	public List<FiscalItem> getFiscalItemList() {
		return fiscalItemList;
	}

	public void setFiscalItemList(List<FiscalItem> fiscalItemList) {
		this.fiscalItemList = fiscalItemList;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}
	
	

	
	

}
