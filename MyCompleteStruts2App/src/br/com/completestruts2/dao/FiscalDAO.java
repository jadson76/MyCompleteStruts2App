package br.com.completestruts2.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.completestruts2.entitys.Fiscal;
import br.com.completestruts2.entitys.FiscalItem;
import br.com.completestruts2.entitys.JPAUtil;

public class FiscalDAO extends JPABasicDAO<Fiscal>{
	
	public List<Fiscal> getAllFiscalByData(Date start, Date stop) {
		return getPureList(Fiscal.class, "select f from Fiscal f where f.dataVenda >= ?1 and <= ?2", start,stop);		
		
	}
	
	public List<FiscalItem> getAllItensByFiscalId(Long idFiscal) {
		return getPureList(FiscalItem.class, "select fi from FiscalItem fi where fi.fiscal.id = ?1 ", idFiscal);		
		
	}
	
	public List<Fiscal> getAllFiscals() {
		return getPureList(Fiscal.class, "select f from Fiscal f");		
		
	}
	
	public void removeFiscalItem(Long idFiscalItem) {
		executeCommand("DELETE FROM FiscalItem fi where fi.id = ?1", idFiscalItem);
	}
	
	public void removeAllFiscalItens(Long idFiscal) {
		executeCommand("DELETE FROM FiscalItem fi where fi.fiscal.id = ?1", idFiscal);
	}
	
	public FiscalItem updateFiscalItens(FiscalItem fi) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		em.merge(fi);
		em.getTransaction().commit();
		em.close();
		return fi;
	}
	
	public void updateAllFiscalItens(List<FiscalItem> itens) {
		for(FiscalItem fiscalItem : itens) {
			updateFiscalItens(fiscalItem);
		}
	}
	
	
	

}
