package br.com.completestruts2.entitys;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "fiscal_item", schema = "struts_app")
@NamedQueries({
	@NamedQuery( name = "FiscalItem.findAll",
		    query = "SELECT fi FROM FiscalItem fi"),
	@NamedQuery( name = "FiscalItem.findById",
    query = "SELECT fi FROM FiscalItem fi WHERE fi.id = :id")	
	
})
public class FiscalItem implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "id",nullable = false)
	private Long id;
	
	@Basic(optional = false)
	@Column(name = "quant",nullable = false)
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "fiscal_id", referencedColumnName = "id")
	private Fiscal fiscal;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Produto produto;

	public FiscalItem() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fiscal getFiscal() {
		return fiscal;
	}

	public void setFiscal(Fiscal fiscal) {
		this.fiscal = fiscal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
	
	

}
