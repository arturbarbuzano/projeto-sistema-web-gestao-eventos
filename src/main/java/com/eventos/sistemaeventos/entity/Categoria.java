package com.eventos.sistemaeventos.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Categoria")
@Table(name = "tb_categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long id;

    @Column(nullable = false, length = 100, name = "categoria_nome")
    private String nome;

    @Column(nullable = false ,length = 255, name = "categoria_descricao")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Evento> eventos;

    public Categoria() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
