package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {
        Categoria categoriaCelular = new Categoria("CELULARES");
        Produto celular = new Produto("Iphone","caro",new BigDecimal("4000"), categoriaCelular);





        EntityManager entityManager = new JPAUtil().getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
        categoriaDAO.cadastrar(categoriaCelular);
        produtoDAO.cadastrar(celular);
        entityManager.getTransaction().begin();



        entityManager.flush();
        entityManager.clear();

        categoriaCelular = entityManager.merge(categoriaCelular);
        categoriaCelular.setNome("XPTO");
        entityManager.flush();

        celular = entityManager.merge(celular);
        entityManager.remove(celular);
        categoriaDAO.remover(categoriaCelular);
        entityManager.flush();



    }
}
