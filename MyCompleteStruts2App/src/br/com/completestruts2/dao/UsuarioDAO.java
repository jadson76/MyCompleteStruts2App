package br.com.completestruts2.dao;

import java.util.List;

import br.com.completestruts2.entitys.Usuario;

public class UsuarioDAO extends JPABasicDAO<Usuario>{
	
	public List<Usuario> getTodosUsuarios() {
		return getPureList(Usuario.class, "select u from Usuario u");
	}
	
	public boolean isUsuarioESenhaValidos(String login, String senha) {
		Usuario usuario = getPurePojo(Usuario.class,"SELECT u from Usuario u where u.login = ?1 AND u.password = ?2" , login, senha);
		if(usuario != null) {
			return true;
		}
		return false;
	}
	
	public List<Usuario> getUsuarioByNome(String nome) {
		return getPureList(Usuario.class, "select u from Usuario u where u.nome like ?1", nome+"%");
	}
}
