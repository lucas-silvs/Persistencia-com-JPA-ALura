package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {
    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto){

        this.entityManager.persist(produto);


    }

    public Produto buscaPorID(Long id){

        return entityManager.find(Produto.class,id);
    }

    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto as p";
        return entityManager.createQuery(jpql,Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome){
        String jpql = "SELECT p FROM Produto as p WHERE p.nome = :nome";
        return entityManager.createQuery(jpql,Produto.class)
                .setParameter("nome",nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoProdutoComNome(String nome){
        String jpql = "SELECT p.preco FROM Produto as p WHERE p.nome = :nome";
        return entityManager.createQuery(jpql,BigDecimal.class)
                .setParameter("nome",nome)
                .getSingleResult();
    }
}
