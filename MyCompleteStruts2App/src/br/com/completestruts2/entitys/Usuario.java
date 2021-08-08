package br.com.completestruts2.entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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
@Table(name = "usuario", schema = "struts_app")
@NamedQueries({
	@NamedQuery( name = "Usuario.findAll",
		    query = "SELECT u FROM Usuario u"),
	@NamedQuery( name = "Usuario.findById",
    query = "SELECT u FROM Usuario u WHERE u.id = :id"),
	@NamedQuery( name = "Usuario.findByNome",
    query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
	@NamedQuery( name = "Usuario.findByPassword",
    query = "SELECT u FROM Usuario u WHERE u.password = :password")
	
})
public class Usuario implements Serializable{

	
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
	@Column(name = "login",nullable = false, length = 100)
	private String login;
	
	@Basic(optional = false)
	@Column(name = "password",nullable = false, length = 32)
	private String password;
	
	@OneToMany(mappedBy = "usuario_id")
	private List<Fiscal> fiscalList;	
	

	public Usuario(Long id, String nome, String login, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.password = password;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	
	
}
