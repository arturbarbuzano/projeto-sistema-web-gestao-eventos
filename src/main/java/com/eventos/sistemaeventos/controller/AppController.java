package com.eventos.sistemaeventos.controller;

import com.eventos.sistemaeventos.entity.Categoria;
import com.eventos.sistemaeventos.entity.Evento;
import com.eventos.sistemaeventos.repository.CategoriaRepository;
import com.eventos.sistemaeventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired private CategoriaRepository categoriaRepository;
    @Autowired private EventoRepository eventoRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/categorias/cadastrar")
    public String cadastrarCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "cadastro-categoria";
    }

    @PostMapping("/categorias/salvar")
    public String salvarCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
        categoriaRepository.save(categoria);
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("mensagem", "Categoria cadastrada com sucesso!");
        return "cadastro-categoria";
    }

    @GetMapping("/eventos/cadastrar")
    public String cadastrarEvento(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("evento", new Evento());
        model.addAttribute("categorias", categorias);
        return "cadastro-evento";
    }

    @PostMapping("/eventos/salvar")
    public String salvarEvento(@ModelAttribute("evento") Evento evento, Model model) {
        eventoRepository.save(evento);
        model.addAttribute("evento", new Evento());
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("mensagem", "Evento cadastrado com sucesso!");
        return "cadastro-evento";
    }

    @GetMapping("/eventos/listar")
    public String listarEventos(Model model) {
        model.addAttribute("eventos", eventoRepository.findAll());
        return "listagem-eventos";
    }
}
