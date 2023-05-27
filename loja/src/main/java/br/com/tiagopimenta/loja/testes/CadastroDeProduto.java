package br.com.tiagopimenta.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.tiagopimenta.loja.dao.CategoriaDao;
import br.com.tiagopimenta.loja.dao.ProdutoDao;
import br.com.tiagopimenta.loja.modelo.Categoria;
import br.com.tiagopimenta.loja.modelo.Produto;
import br.com.tiagopimenta.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(celulares);
		celulares.setNome("XPTO");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		celulares.setNome("1234");
		
		em.flush();
		em.clear();
		
		em.remove(celulares);
		em.flush();
	}

}
