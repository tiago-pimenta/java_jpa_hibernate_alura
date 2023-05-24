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
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

}
