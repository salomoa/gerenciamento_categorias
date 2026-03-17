package com.bn.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "categoria")
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    @Column(name = "descricao_cat")
    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
