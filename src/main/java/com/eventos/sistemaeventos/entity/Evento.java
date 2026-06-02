package com.eventos.sistemaeventos.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Evento")
@Table(name = "tb_eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private Long id;

    @Column(nullable = false, length = 100, name = "evento_nome")
    private String nome;

    @Column(nullable = false, length = 255, name = "evento_descricao")
    private String descricao;

    @Column(nullable = false, name = "data")
    private LocalDate data;

    @Column(nullable = false, length = 255, name = "evento_local")
    private String local;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Evento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
