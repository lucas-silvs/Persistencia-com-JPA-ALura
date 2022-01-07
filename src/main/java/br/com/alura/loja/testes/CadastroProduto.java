package br.com.alura.loja.testes;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Iphone");
        celular.setDescricao("Classico");
        celular.setPreco(new BigDecimal("40000"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();


    }
}
