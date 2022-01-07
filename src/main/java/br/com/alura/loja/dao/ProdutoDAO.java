package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {
    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto){
        entityManager.getTransaction().begin();
        this.entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
