package br.com.completestruts2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.completestruts2.entitys.FiscalItem;
import br.com.completestruts2.entitys.JPAUtil;
import br.com.completestruts2.entitys.Produto;

public class ProdutoDAO extends JPABasicDAO<Produto>{
	
	public List<Produto> getTodosProdutos() {
		return getPureList(Produto.class, "select p from Produto p");
	}
	
	public List<Produto> getProdutoByNome(String nome) {
		return getPureList(Produto.class, "select p from Produto p where p.nome like ?1", nome+"%");
	}
	
	public List<FiscalItem> getFiscalItemByProduto(Produto prod) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		em.merge(prod);
		List<FiscalItem> itens =  prod.getFiscalItemList();
		em.getTransaction().commit();
		em.close();
		return itens;		
		
	}

}
