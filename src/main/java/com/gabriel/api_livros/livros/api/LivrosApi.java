package com.gabriel.api_livros.livros.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabriel.api_livros.livros.dto.LivroDTO;
import com.gabriel.api_livros.livros.facade.LivrosFacade;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
@RequestMapping(value = "/livros", produces = MediaType.APPLICATION_JSON_VALUE)


public class LivrosApi {
    @Autowired
    private LivrosFacade livrosFacade;

    @PostMapping
    @ResponseBody
    public LivroDTO criar(@RequestBody LivroDTO livroDTO){
       return livrosFacade.criar(livroDTO);
    };

    @PutMapping("/{livroId}")
    @ResponseBody
    public LivroDTO atualizar( @PathVariable("livroId") Long livroId, @RequestBody LivroDTO livroDTO){
        return livrosFacade.atualizar(livroDTO,livroId);
    };

    @GetMapping
    @ResponseBody
    public List<LivroDTO> getAll() {
        return livrosFacade.getAll();
    }

    @DeleteMapping("/{livroId}")
    @ResponseBody
    public String deletar(@PathVariable("livroId") Long livroId ) {
        return livrosFacade.delete(livroId);
    }
    

}
