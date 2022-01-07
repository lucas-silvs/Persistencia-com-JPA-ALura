package br.com.alura.loja.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    //@Column(name"desc") - é utilizado @Column caso o nome da coluna for diferente do nome da variavel, assim apontando a coluna para a variavel que tem a anotação
    private String descricao;

    private BigDecimal preco;



}
