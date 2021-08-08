package br.com.completestruts2.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "fiscal", schema = "struts_app")
@NamedQueries({
	@NamedQuery( name = "Fiscal.findAll",
		    query = "SELECT f FROM Fiscal f"),
	@NamedQuery( name = "Fiscal.findById",
    query = "SELECT f FROM Fiscal f WHERE f.id = :id"),
	@NamedQuery( name = "Fiscal.findByDataVenda",
    query = "SELECT f FROM Fiscal f WHERE f.data_venda = :dataVenda"),
	@NamedQuery( name = "Usuario.findByUsuarioId",
    query = "SELECT u FROM Usuario u WHERE u.usuario.id = :usuarioId")
	
})
public class Fiscal implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id",nullable = false)
	private Long id;
	
	@Basic(optional = false)
	@Column(name = "data_venda",nullable = false)
	private Date dataVenda;
	
	@Basic(optional = false)
	@Column(name = "descricao",nullable = false, length = 255)
	private String descricao;
	
	@Basic(optional = false)	
	@Column(name = "preco",nullable = false, columnDefinition = "DECIMAL(16,2)")
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;	
	

	public Fiscal(Long id, Date dataVenda, String descricao, BigDecimal total, Usuario usuario) {
		super();
		this.id = id;
		this.dataVenda = dataVenda;
		this.descricao = descricao;
		this.total = total;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setPreco(BigDecimal total) {
		this.total = total;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Fiscal [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Fiscal other = (Fiscal) obj;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
	

}
