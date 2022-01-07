package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(categoria);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
}
