package com.gabriel.api_livros.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.api_livros.dto.LivroDTO;
import com.gabriel.api_livros.facade.LivrosFacade;


@RestController
@RequestMapping(value = "/livros", produces = MediaType.APPLICATION_JSON_VALUE)
public class LivrosApi {
    @Autowired
    private LivrosFacade livrosFacade;

    @PostMapping
    public LivroDTO criar(@RequestBody LivroDTO livroDTO) {
        return livrosFacade.criar(livroDTO);
    }

    @PutMapping("/{livroId}")
    public LivroDTO atualizar(@PathVariable("livroId") Long livroId, @RequestBody LivroDTO livroDTO) {
        return livrosFacade.atualizar(livroDTO, livroId);
    }

    @GetMapping
    public List<LivroDTO> getAll() {
        return livrosFacade.getAll();
    }

    @DeleteMapping("/{livroId}")
    public void deletar(@PathVariable("livroId") Long livroId) {
        livrosFacade.deletar(livroId);
    }
}